package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    ConnectioDB c = new ConnectioDB();

//    PreparedStatement preparedStatement;
//    ResultSet resultSet;
//    Connection con;
    public List<People> Lists()
    {
        ArrayList<People> list = new ArrayList<>();

        try
        {

            Connection con = c.getConnection();

            String sql = "SELECT * FROM people order by id";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
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
