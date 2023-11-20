/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut;

import java.text.NumberFormat;
import java.util.ArrayList;
import vut.PatientPD.PatientType;

/**
 *
 * @author Matimu Baloyi 219059802
 */
public class PatientPD
{

    /**
     * Sub class to manage Patient Type as Constants
     */
    public enum PatientType
    {
        IN_PATIENT, OUT_PATIENT
    }

    private String surname, id;
    private double amountDue;
    private NumberFormat currency = NumberFormat.getCurrencyInstance();
    private PatientType patientType;

    /**
     * Default constructor, with no values
     */
    public PatientPD()
    {
    }

    /**
     * Create new Patient with the given Patient details
     *
     * @param surname
     * @param id
     * @param patientType
     * @param amountDue
     */
    public PatientPD(String surname, String id, PatientType patientType, double amountDue)
    {
        this.surname = surname;
        this.id = id;
        this.patientType = patientType;
        this.amountDue = amountDue;

    }

    /**
     * Change PatientPD Surname
     *
     * @param surname
     */
    public void setSurname(String surname)
    {
        if (surname != null && surname.length() > 3)
        {
            this.surname = surname;
        }
        else
        {
            throw new IllegalArgumentException("Surname must contain a value or value is less than 3 characters");
        }
    }

    /**
     * Change PatientPD Id number
     *
     * @param id
     */
    public void setID(String id)
    {
        if (id != null)
        {
            if (id.matches("\\d{13}"))
            {
                this.id = id;
            }
            else
            {
                throw new IllegalArgumentException("ID Number must contain 13 digits");
            }
        }
        else
        {

            throw new IllegalArgumentException("ID Number must a value");
        }
    }

    /**
     * change PatientType
     *
     * @param patientType
     */
    public void setPatientType(PatientType patientType)
    {
        this.patientType = patientType;
    }

    /**
     * change PatientPD Amount Due
     *
     * @param amountDue
     */
    public void setAmountDue(double amountDue)
    {
        this.amountDue = amountDue;
    }

    /**
     * Function to return PatientPD Surname
     *
     * @return
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * Access PatientPD Id Number
     *
     * @return id number of patient
     */
    public String getId()
    {
        return id;
    }

    /**
     * send out PatientPD type
     *
     * @return patientType
     */
    public PatientType getPatientType()
    {
        return patientType;
    }

    /**
     * Access PatientPD Amount Due
     *
     * @return amountDue of a PatientPD
     */
    public double getAmountDue()
    {
        return amountDue;
    }

    @Override
    public String toString()
    {
        return surname + "\t" + id + "\t" + patientType + "\t" + currency.format(amountDue) + "\n";
    }

    /**
     * Method to connect to the database 'Patientdb'
     *
     * @throws DataStorageException
     */
    public void getConnection() throws DataStorageException
    {
        PatientDA.getConnection();
    }

    /**
     * method to retrieve and return all the records from tblPatients
     *
     * @return
     * @throws NotFoundException
     */
    public ArrayList<PatientPD> getAll() throws NotFoundException
    {
        return PatientDA.getAll();
    }

    /**
     * Function to retrieve and return all ID numbers from the table
     *
     * @return
     * @throws NotFoundException
     */
    public ArrayList<String> getIDnumbers() throws NotFoundException
    {
        return PatientDA.getIDnumbers();
    }

    /**
     * receives the ID number as a parameter and returns all the details about
     * the patient with the corresponding ID number from the table.
     *
     * @param idNr
     * @return
     * @throws NotFoundException
     */
    public PatientPD getPatientObj(String idNr) throws NotFoundException
    {
        return PatientDA.getPatientObj(idNr);
    }

    /**
     * Method to updates the table 'Patientdb
     *
     * @param amountDue
     * @param idNr
     * @throws NotFoundException
     */
    public void updateAmountDue(double amountDue, String idNr) throws NotFoundException
    {
        PatientDA.updateAmountDue(amountDue, idNr);
    }

    /**
     * This method receives the type of a patient as a parameter , retrieves and
     * return all the details about the specified type of patients. Allow the
     * user to type in or in_P to indicate that they want to view in-patients
     * and o,out or out_p, to indicate that they want to view outpatients
     *
     * @param patientType
     * @return  PatientPD
     * @throws NotFoundException
     */
    public ArrayList<PatientPD> returnPatientType(String patientType) throws NotFoundException
    {
       return PatientDA.returnPatientType(patientType);
    }

    /**
     * Method to add the record to the table.
     *
     * @param objPatient
     * @throws DuplicateException
     */
    public void addPatient(PatientPD objPatient) throws DuplicateException
    {
        PatientDA.addPatient(objPatient);
    }

    /**
     * Method to calculates and returns the total amount due by all the patients
     * in the database
     *
     * @return
     * @throws NotFoundException
     */
    public double calculateTotalAmountDue() throws NotFoundException
    {
        return PatientDA.calculateTotalAmountDue();
    }

    /**
     * method to calculates the total amount due by out-patients only.
     *
     * @return
     * @throws NotFoundException
     */
    public double calculateTotalOutPatients() throws NotFoundException
    {
        return PatientDA.calculateTotalOutPatients();
    }

    /**
     * method to calculates and returns the total amount due by in-patients
     * only.
     *
     * @return
     * @throws NotFoundException
     */
    public double calculateTotalInPatients() throws NotFoundException
    {
        return PatientDA.calculateTotalInPatients();
    }
    
    /**
     *method to Terminate connection 
     * @throws DataStorageException
     */
    public void terminate() throws DataStorageException {
        PatientDA.terminate();
    }
    
    /**
     *Remove
     * @param idNr
     * @throws NotFoundException
     */
    public void removePatient(String idNr) throws NotFoundException {
        PatientDA.removePatient(idNr);
    }


}
