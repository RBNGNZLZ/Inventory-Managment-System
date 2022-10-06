import java.util.*;

public class ReportsManager {

    public void generateReport(int reportType, String fileName, String storeName, String transactionType) {
        //W.I.P.
        if(reportType == 1) {
            //IncomingOutgoingReport newIncOutReport = new IncomingOutgoingReport(fileName, outincType);
            System.out.println("Reached IncomingOutgoingReport.");
            IncomingOutgoingReport.printInOutReport(fileName, transactionType);
        }
        else if(reportType == 2) {
            //SpecificStoreSearch specificStoreReport = new SpecificStoreSearch(fileName, storeName);
            System.out.println("Reached SpecificStoreSearchReport.");
            SpecificStoreSearchReport.printSpecificStoreSearchReport();
        }
        else {
            //InventoryReport newInvReport = new InventoryReport(fileName);
            System.out.println("Reached InventoryReport.");
            InventoryReport.printInventoryReport();
        }

    }

}
