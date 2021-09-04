import java.util.Scanner;

public class StageControll {

    private LineAndStation repo;
    Scanner scan =new Scanner(System.in);
    String n, m,l;

    public StageControll(LineAndStation repo) {
        this.repo=repo;
    }

    public void choice(String name){
        switch (name){
            case "1":
                System.out.println("## 노선을 입력하세요.");
                n=scan.next();
                System.out.println("## 역이름을 입력하세요.");
                m=scan.next();
                System.out.println("## 순서를 입력하세요.");
                l=scan.next();
                repo.save(n,new Station(m),Integer.parseInt(l));
                System.out.println("\n[INFO] 구간이 등록되었습니다.\n");
                break;
            case "2":
                System.out.println("## 삭제할 구간의 노선을 입력하세요.");
                n=scan.next();
                System.out.println("## 삭제할 구간의 역을 입력하세요.");
                m=scan.next();
                repo.remove(n,m);
                System.out.println("\n[INFO] 구간이 삭제되었습니다.");
                break;
            case "B":
                break;
            default:

        }
    }
}
