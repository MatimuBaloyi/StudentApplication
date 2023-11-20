/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut;

import vut.PatientPD.PatientType;

/**
 *
 * @author Matimu Baloyi 219059802
 */
public class ClassTest
{

    
    /**
     * @param args the command line arguments
     * @throws vut.NotFoundException
     */
    public static void main(String[] args) throws NotFoundException
    {

        PatientPD obj1 = new PatientPD("Sue", "9902056160083", PatientType.OUT_PATIENT, 200);
        System.out.println("Surname" + "\t" + "ID_Number" + "\t" + "Patient_Type" + "\t" + "Amount_Due" + "\n" + ".........................................................." );
        System.out.println(obj1.toString());
        

    }

}
