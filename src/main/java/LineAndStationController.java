import java.util.Scanner;

public class LineAndStationController {
    private LineAndStation repo;
    String n, m,l;

    public LineAndStationController(LineAndStation repo) {
        this.repo=repo;
    }

    public void prinall(){
        for (String nameLine:repo.getinstance().keySet()) {
            System.out.println("[INFO] "+nameLine);
            System.out.println("[INFO] ---");
            for (Station s:repo.getinstance().get(nameLine).getinstance()) {
                System.out.println("[INFO] "+s.getName());
            }
            System.out.println("");
        }
    }
}
