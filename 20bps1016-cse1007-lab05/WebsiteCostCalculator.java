// Write a Java program to compute the cost of building a website. 
// The total cost is the sum of cost for frontend design, 
// client side scripting and server side scripting. 
// Use multiple inheritance to find the total cost of building a website.

interface FrontendDesign {
    int calculateFrontendCost(int hours);
}

interface ClientSideScripting {
    int calculateClientSideCost(int hours);
}

interface ServerSideScripting {
    int calculateServerSideCost(int hours);
}

class Website implements FrontendDesign, ClientSideScripting, ServerSideScripting {
    private final int frontendCostPerHour = 50;
    private final int clientSideCostPerHour = 75;
    private final int serverSideCostPerHour = 100;

    @Override
    public int calculateFrontendCost(int hours) {
        return hours * frontendCostPerHour;
    }

    @Override
    public int calculateClientSideCost(int hours) {
        return hours * clientSideCostPerHour;
    }

    @Override
    public int calculateServerSideCost(int hours) {
        return hours * serverSideCostPerHour;
    }

    public int getTotalCost(int frontendHours, int clientSideHours, int serverSideHours) {
        return calculateFrontendCost(frontendHours) +
                calculateClientSideCost(clientSideHours) +
                calculateServerSideCost(serverSideHours);
    }
}

public class WebsiteCostCalculator {
    public static void main(String[] args) {
        Website myWebsite = new Website();
        int frontendHours = 50;
        int clientSideHours = 100;
        int serverSideHours = 150;
        int totalCost = myWebsite.getTotalCost(frontendHours, clientSideHours, serverSideHours);
        System.out.println("Total cost of building the website: $" + totalCost);
    }
}
