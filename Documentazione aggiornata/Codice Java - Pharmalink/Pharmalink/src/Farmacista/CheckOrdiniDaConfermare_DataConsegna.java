package Farmacista;

public class CheckOrdiniDaConfermare_DataConsegna{
    static String dataConsegnaCheck;
    public CheckOrdiniDaConfermare_DataConsegna(String dataConsegnaCheck){
        this.dataConsegnaCheck = dataConsegnaCheck;
    }

    public static String getDataConsegnaCheck() {
        return dataConsegnaCheck;
    }
}