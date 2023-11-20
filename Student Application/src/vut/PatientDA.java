/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut;

import java.sql.*;
import java.util.ArrayList;
import vut.PatientPD.*;

/**
 * Patient Data Access Class
 *
 * @author Matimu Baloyi 219059802
 */
public  class PatientDA
{

    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private PatientType patientType;
    private static Statement st;

    private static ArrayList<PatientPD> arListPatient = new ArrayList();

    /**
     * Method to connect to the database 'Patientdb'
     *
     * @throws DataStorageException
     */
    public static void getConnection() throws DataStorageException
    {
        final String USERNAME = "root";
        final String PASSWORD = "";
        final String URL = "jdbc:mysql://localhost/patientDb";
        final String DRIVER = "com.mysql.jdbc.Driver";

        try
        {
            //Register Driver
            Class.forName(DRIVER);

            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        }
        catch (ClassNotFoundException ex)
        {

            throw new DataStorageException("Database Driver not Found :" + ex.getMessage());
        }
        catch (SQLException ex)
        {

            throw new DataStorageException("ERROR! \n" + ex.getMessage());
        }
    }

    /**
     * method to retrieve and return all the records from tblPatients
     *
     * @return arListPatient
     * @throws NotFoundException
     */
    public static ArrayList<PatientPD> getAll() throws NotFoundException
    {

        arListPatient.clear();

        String query = "SELECT * FROM  tblPatients";

        try
        {
            // send your query to the database using ur preparedstatement and your connection object
            ps = con.prepareStatement(query);
            // execute and store the returned query result in resultset object
            rs = ps.executeQuery();

            while (rs.next())
            {

                arListPatient.add(new PatientPD(rs.getString(1), rs.getString(2), PatientType.valueOf(rs.getString(3)), rs.getDouble(4)));
            }
        }
        catch (SQLException ex)
        {
            throw new NotFoundException("No data retrieved \n" + ex.getMessage());
        }
        return arListPatient;
    }

    /**
     * Function to retrieve and return all ID numbers from the table
     *
     * @return arrID_Numbers , ID Numbers of Patients
     * @throws NotFoundException
     */
    public static ArrayList<String> getIDnumbers() throws NotFoundException
    {

        ArrayList<String> arrListID_No = new ArrayList<>();

        String qry = "SELECT ID_Number  FROM tblPatients";

        try
        {
            ps = con.prepareStatement(qry);
            rs = ps.executeQuery();

            while (rs.next())
            {
                arrListID_No.add(rs.getString("ID_Number"));
            }
        }
        catch (SQLException e)
        {
            throw new NotFoundException(e.getMessage());
        }
        return arrListID_No;
    }

    /**
     * receives the ID number as a parameter and returns all the details about
     * the patient with the corresponding ID number from the table.
     *
     * @param idNr
     * @return objPatient
     * @throws NotFoundException
     */
    public static PatientPD getPatientObj(String idNr) throws NotFoundException
    {

        String qry = "SELECT * FROM tblPatients WHERE ID_Number = ?";   //   ? means value will be given

        PatientPD objPatient = null;

        try
        {
            ps = con.prepareStatement(qry);
            ps.setString(1, idNr);  //correspond with the parameters

            //ps.executeUpdate();
            rs = ps.executeQuery();

            rs.next();
            objPatient = new PatientPD(rs.getString(1), rs.getString(2), PatientType.valueOf(rs.getString(3)), rs.getDouble(4));

        }
        catch (SQLException ex)
        {
            throw new NotFoundException("Error:" + ex.getMessage());
        }
        return objPatient;
    }

    /**
     * Method to updates the table 'Patientdb
     *
     * @param amountDue
     * @param idNr
     * @throws NotFoundException
     */
    public static void updateAmountDue(double amountDue, String idNr) throws NotFoundException
    {
        String qry = "UPDATE tblPatients SET  Amount_due = amount_due - ? WHERE ID_Number = ? ";

        try
        {
            ps = con.prepareStatement(qry);
            ps.setDouble(1, amountDue);   //correspond with the  method parameters
            ps.setString(2, idNr);
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new NotFoundException(" Update Error: " + e.getMessage());
        }

    }

    /**
     * This method receives the type of a patient as a parameter , retrieves and
     * return all the details about the specified type of patients. Allow the
     * user to type in or in_P to indicate that they want to view in-patients
     * and o,out or out_p, to indicate that they want to view outpatients
     *
     * @param patientType
     * @return arListPatient
     * @throws NotFoundException
     */
    public static ArrayList<PatientPD> returnPatientType(String patientType) throws NotFoundException
    {
        // initialize qry by selecting all Patient types
        String qry = "SELECT* FROM tblPatients   WHERE Patient_Type LIKE ?";
        arListPatient.clear();

        try
        {
            ps = con.prepareStatement(qry);
            ps.setString(1, "%" + patientType + "%");   //correspond with the methods`1 parameters
            rs = ps.executeQuery();

            while (rs.next())
            {

                arListPatient.add(new PatientPD(rs.getString(1), rs.getString(2), PatientType.valueOf(rs.getString(3)), rs.getDouble(4)));
            }
        }
        catch (SQLException ex)
        {
            throw new NotFoundException("No record(s) retrieved" + ex.getMessage());
        }
        return arListPatient;

    }

    /**
     * Method to add the record to the table.
     *
     * @param objPatient, receive Patient PD object
     * @throws DuplicateException
     */
    public static void addPatient(PatientPD objPatient) throws DuplicateException
    {

        String qry = "INSERT INTO tblPatients VALUES(?,?,?,?)";

        try
        {

            ps = con.prepareStatement(qry);
            ps.setString(1, objPatient.getId());
            ps.setString(2, objPatient.getSurname());   //correspond with the  table columns
            ps.setString(3, objPatient.getPatientType().toString());
            ps.setDouble(4, objPatient.getAmountDue());
            ps.executeUpdate();

        }
        catch (SQLException ex)
        {
            throw new DuplicateException("Error:  " + objPatient.getSurname() + " Not Added" + ex.getMessage());
        }

    }

    /**
     * Method to calculates and returns the total amount due by all the patients
     * in the database
     *
     * @return totalAmountDue
     * @throws NotFoundException
     */
    public static double calculateTotalAmountDue() throws NotFoundException
    {
        double totalAmountDue = 0;

        String qry = "select  Amount_due from tblPatients";

        try
        {
            ps = con.prepareStatement("select  Amount_due from tblPatients");
            rs = ps.executeQuery();

            while (rs.next())
            {
                totalAmountDue += rs.getDouble(1);   // its 1 because qry will return only 1 column

            }
        }
        catch (SQLException ex)
        {
            throw new NotFoundException("No data retrieved" + ex.getMessage());
        }

        return totalAmountDue;
    }

    /**
     * method to calculates the total amount due by out-patients only.
     *
     * @return
     * @throws NotFoundException
     */
    public static double calculateTotalOutPatients() throws NotFoundException
    {
        double totalOutPatientsAmountDue = 0;
        String qry = " SELECT  Amount_due FROM tblPatients  WHERE  Patient_Type = 'OUT_PATIENT'";

        try
        {
            ps = con.prepareStatement(qry);
            rs = ps.executeQuery();

            while (rs.next())
            {
                totalOutPatientsAmountDue += rs.getDouble(1);

            }
        }
        catch (SQLException ex)
        {
            throw new NotFoundException("No data retrieved" + ex.getMessage());
        }

        return totalOutPatientsAmountDue;
    }

    /**
     * method to calculates and returns the total amount due by in-patients
     * only.
     *
     * @return
     * @throws NotFoundException
     */
    public static double calculateTotalInPatients() throws NotFoundException
    {

        String qry = " SELECT  Amount_due FROM tblPatients  WHERE  Patient_Type = 'IN_PATIENT'";
        double totalInPatientsAmountDue = 0;

        try
        {
            ps = con.prepareStatement(qry);
            rs = ps.executeQuery();

            while (rs.next())
            {
                totalInPatientsAmountDue += rs.getDouble(1);

            }
        }
        catch (SQLException ex)
        {
            throw new NotFoundException("No data retrieved" + ex.getMessage());
        }

        return totalInPatientsAmountDue;
    }

    /**
     * method to Terminate connection
     *
     * @throws DataStorageException
     */
    public static void terminate() throws DataStorageException
    {

        try
        {
            if (con != null)
            {
                con.close();
            }

        }
        catch (SQLException ex)
        {
            throw new DataStorageException("No data retrieved" + ex.getMessage());
        }

    }

    public static void removePatient(String idNr) throws NotFoundException
    {
        try
        {
            String qry = "DELETE FROM tblPatients WHERE store = ?";

            ps = con.prepareStatement("DELETE FROM tblPatients WHERE store = ?");
            ps.setString(1, idNr);
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new NotFoundException("Failed to delete Store !" + ex.getMessage());
        }

    }
}
