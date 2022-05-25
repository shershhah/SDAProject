package HSMS.Applicant;

import HSMS.DBHandlers.ApplicantDBHandler;

import java.util.ArrayList;

public class ApplicantRecords {

    //private static ApplicantRecords applicantRecords = null;

    ArrayList<Applicant> ApplicantRecords = new ArrayList<Applicant>();
    ApplicantDBHandler db = new ApplicantDBHandler();

    public int assignID(){
        int t = 0;
        boolean check = false;
        while(!check){
            t = genID();
            if(!exists(t)){
                return t;
            }
        }
        return t;
    }

    public int genID(){
        int min = 10000;
        int max = 20000;

        int tempID = (int)(Math.random()*(max-min+1)+min);

        return tempID;
    }

    public boolean exists(int ID){
        for(Applicant a: ApplicantRecords){
            if (a.getID() == ID)
                return true;
        }

        return false;
    }

    public Applicant applicantCreation(String fname, String lname, int cninc, String email){
        int tempID = assignID();
        Applicant temp = new Applicant(tempID,fname,lname,cninc,email);
        ApplicantRecords.add(temp);
        db.saveApplicant(temp);

        return temp;
    }

    public Applicant applicantCreation(String fname, String lname, int cninc, String email, boolean check){
        // owner DBHandler check if applicant cnic  ==  registered owner CNIC

//        public static ArrayList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException {
//            Connection conn=DBConnection.getDBConnection().getConnection();
//            Statement stm;
//            stm = conn.createStatement();
//            String sql = "Select * From Customer";
//            ResultSet rst;
//            rst = stm.executeQuery(sql);
//            ArrayList<Customer> customerList = new ArrayList<>();
//            while (rst.next()) {
//                Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
//                customerList.add(customer);
//            }
//            return customerList;
//        }

        Applicant temp = new Applicant(assignID(),fname,lname,cninc,email);
        ApplicantRecords.add(temp);
        db.saveApplicant(temp);

        return temp;
    }

    public Applicant getApplicant(int ID){
        for(Applicant a : ApplicantRecords){
            if(a.getID() == ID){
                return a;
            }
        }
        return null;
    }
}
