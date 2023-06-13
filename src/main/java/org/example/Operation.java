package org.example;

import java.sql.*;

public class Operation {

    Connection connection;
    UserInput userInput;
    public Operation(Connection connection, UserInput userInput) {
        this.connection = connection;
        this.userInput = userInput;
    }

    public void firstQueryCall() {
        try (final PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, code from country ");
             PreparedStatement cityNamePreparedStatement = connection.prepareStatement("SELECT  c2.names, c2.population  from country c " +
                     "JOIN city c2 ON c.code = c2.country_code " +
                     "WHERE c.name  = ? " +
                     "ORDER BY c2.population desc");
             ResultSet rs = preparedStatement.executeQuery();

        ) {
            while (rs.next()) {
                System.out.printf("%s ,", rs.getString("Name"));
            }
            System.out.println();
            String country = userInput.chooseCountry();
            cityNamePreparedStatement.setString(1, country);
           try (ResultSet resultSet = cityNamePreparedStatement.executeQuery();) {
               while (resultSet.next()) {
                   System.out.printf("%30s %,12d%n",
                           resultSet.getString("Names"), resultSet.getInt("Population"));
               }
           }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public void secondQueryCall() {

        try (final PreparedStatement preparedStatement = connection.prepareStatement("SELECT DISTINCT continent from country ");
             ResultSet resultSet = preparedStatement.executeQuery();
             PreparedStatement ContinentPreparedStatement = connection.prepareStatement("select distinct c.continent ,c.name , c2.names " +
                     "from country c " +
                     "join city c2 on c.capital = c2.id " +
                     "where continent = ? and c.capital = c2.id " +
                     "order by c.name");
        ) {
            while (resultSet.next()) {
                System.out.printf("%s ,", resultSet.getString("continent"));
            }
            System.out.println();
            String continent = userInput.chooseContinent();
            ContinentPreparedStatement.setString(1, continent);
            try (ResultSet resultSet1 = ContinentPreparedStatement.executeQuery();) {
                while (resultSet1.next()) {
                    System.out.printf("%10s %30s %30s%n",
                            resultSet1.getString("Continent"), resultSet1.getString(2), resultSet1.getString("names"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void thirdQueryCall() {
        String city = userInput.chooseCity();
        try (final PreparedStatement preparedStatement = connection.prepareStatement("select c.names , c2.name , " +
                "round((c.population / c2.population :: numeric)*100, 3) as citypopulation , (c.id = c2.capital ) as capital from city c " +
                "join country c2 on c.country_code = c2.code " +
                "left join country c3 on c.id = c3.capital " +
                "where c.names = ? ");
        ) {
            preparedStatement.setString(1, city);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.printf("%10s %10s %5d %15s%n",
                            resultSet.getString("Names"), resultSet.getString("Name"),
                            resultSet.getInt("citypopulation"), resultSet.getBoolean("capital") ? "Főváros" : "nem Főváros");
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void fourthQueryCall() {
        String language = userInput.chooseLanguage();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select cl.language  ,c.name , round((( c.population * cl.percentage ):: numeric ),2) as number_of_language_speakers , is_official " +
                     "from country_language cl " +
                     "join country c on cl.country_code = c.code " +
                     "where language = ? " +
                     "order by is_official desc,  number_of_language_speakers desc ");

        ) {
                preparedStatement.setString(1, language);
                try (ResultSet resultSet = preparedStatement.executeQuery();){
                while (resultSet.next()) {
                    System.out.printf("%20s %40s %,25d %25s %n", resultSet.getString("language"), resultSet.getString("name"),
                            resultSet.getLong("number_of_language_speakers"),
                            resultSet.getBoolean("is_official") ? "hivatalos nyelv" : "nem hivatalos nyelv");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void fifthQueryCall() {
        Integer number = userInput.chooseNumberOfLanguageSpeaker();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from (select cl.language, count(c.name)  as number_of_countries " +
                     " ,round ((sum(c.population * cl.percentage / 100):: numeric ), 0) as number_of_language_speaker" +
                     " from country_language cl join country c on cl.country_code = c.code group by cl.language) number_of_speaker " +
                     " where number_of_language_speaker > ? order by number_of_language_speaker desc");
        ) {
            preparedStatement.setInt(1, number);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    System.out.printf("%20s %40d %,25d %n", resultSet.getString("language"), resultSet.getInt("number_of_countries"),
                            resultSet.getInt("number_of_language_speaker"));

                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void sixthQueryCall() {
        try (PreparedStatement preparedStatement = connection.prepareStatement("select continent  , avg(gnp/population) as gnp_per_population from country c " +
                     "where population > 0 " +
                     "group by continent " +
                     "order by gnp_per_population desc");

        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                double sum_gnp = 0;
                int numberOfGnp = 0;

                while (resultSet.next()) {
                    System.out.printf("%20s %20f %n", resultSet.getString("continent"), resultSet.getDouble("gnp_per_population"));
                    numberOfGnp++;
                    sum_gnp += resultSet.getDouble("gnp_per_population");
                }
                System.out.printf("Az átlagos gnp: %f%n", sum_gnp / numberOfGnp);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}


