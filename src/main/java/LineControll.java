import java.util.Scanner;

public class LineControll {
    private LineAndStation repo;
    private StationRepository stationlists;//역목록에 관한것.
    Scanner scan =new Scanner(System.in);
    String n, m,l;

    public LineControll(LineAndStation repo,StationRepository stationlists) {
        this.repo=repo;
        this.stationlists=stationlists;
    }

    public void choice(String name){
        switch (name){
            case "1":
                System.out.println("## 등록할 노선 이름을 입력하세요.");
                n=scan.next();
                System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
                m=scan.next();
                System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요");
                l=scan.next();
                if(stationlists.serachAndGet(m)==null){
                    stationlists.save(new Station(m));
                }
                if(stationlists.serachAndGet(l)==null){
                    stationlists.save(new Station(l));
                }
                repo.save(new Line(n),stationlists.serachAndGet(m),stationlists.serachAndGet(l));
                System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.\n");
                break;
            case "2":
                System.out.println("## 삭제할 노선 이름을 입력하세요.");
                n=scan.next();
                repo.remove(n);
                System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
                break;
            case "3":
                System.out.println("## 노선 목록");
                repo.search();
                System.out.println("");
                break;
            case "B":
                break;
            default:

        }
    }

}
