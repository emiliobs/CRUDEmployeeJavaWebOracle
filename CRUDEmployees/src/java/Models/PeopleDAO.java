package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

/**
 *
 * @author Emilio
 */
public class PeopleDAO
{

    ConnectioDB connectioDB;

    public PeopleDAO()
    {
        connectioDB = new ConnectioDB();

    }

    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Connection connection;

    public List<People> Lists()
    {
        ArrayList<People> list = new ArrayList<>();

        try
        {

            connection = connectioDB.getConnection();

            String sql = "SELECT * FROM PEOPLE order by id";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                People people = new People();
                people.setId(resultSet.getString(1));
                people.setName(resultSet.getString(2));
                people.setEmail(resultSet.getString(3));
                people.setPhone(resultSet.getString(4));

                list.add(people);
            }

        }
        catch (Exception e)
        {
            System.out.println("Sorry: Could not read Data for List." + e.getMessage());
        }

        return list;
    }

    public int add(People people)
    {
        int result = 0;

        String sql = "INSERT INTO people (id,name,email,phone ) VALUES (?,?,?,?)";

        try
        {
            connection = connectioDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, people.getId());
            preparedStatement.setString(2, people.getName());
            preparedStatement.setString(3, people.getEmail());
            preparedStatement.setString(4, people.getPhone());

            result = preparedStatement.executeUpdate();
            if (result == 1)
            {
                result = 1;
            }
            else
            {
                result = 0;
            }

        }
        catch (Exception e)
        {
            System.out.println("Sorry: The  Person could not be Saved: " + e.getMessage());
        }

        return result;

    }

    public People getPeopleById(String id)
    {
        String sql = "Select * from people Where Id =" + id;

        People people = new People();

        try
        {
            connection = connectioDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                people.setId(resultSet.getString(1));
                people.setName(resultSet.getString(2));
                people.setEmail(resultSet.getString(3));
                people.setPhone(resultSet.getString(4));
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: There is not  People with Id: " + e.getMessage());
        }

        return people;
    }
    
    public int edit(People people)
    {
          int result = 0;
          
          String sql = "Update people Set name=?, email=?, phone=? Where id=?";
          
          try
        {
            connection = connectioDB.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, people.getName());
            preparedStatement.setString(2, people.getEmail());
            preparedStatement.setString(3, people.getPhone());
            preparedStatement.setString(4, people.getId());
            
            result = preparedStatement.executeUpdate();
            if (result == 1)
            {
                result = 1;
            }
            else
            {
                result = 0;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Edit DAO Error: " + e.getMessage());
        }
          
          return result;
    }

    public static void main(String[] args)
    {
        PeopleDAO peopleDAO = new PeopleDAO();

        List<People> peoples = new ArrayList<>();
        peoples = peopleDAO.Lists();

        for (People people : peoples)
        {
            System.out.println("People: " + people.getName());

        }

    }
}
