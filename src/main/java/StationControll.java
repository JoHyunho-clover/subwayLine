
//역 관리
/*
1. 역 등록
2. 역 삭제
3. 역 조회
B. 돌아가기
* */

import java.util.Scanner;

public class StationControll {
    //private String name;
    private StationRepository repo;
    Scanner scan =new Scanner(System.in);
    String n;

    public StationControll(StationRepository repo) {
        //this.name = name;
        this.repo=repo;
    }

    public void choice(String name){
        switch (name){
            case "1":
                System.out.println("## 등록할 역 이름을 입력하세요.");
                n=scan.next();
                if(repo.serachAndGet(n)==null){
                    repo.save(new Station(n));
                    System.out.println("\n[INFO] 지하철 역이 등록되었습니다.\n");
                }else{
                    System.out.println("\n[ERROR] 이미 등록된 역 이름입니다.\n");
                }
                break;
            case "2":
                System.out.println("## 삭제할 역 이름을 입력하세요.");
                n=scan.next();
                repo.remove(n);
                break;
            case "3":
                System.out.println("## 역목록");
                repo.printall();
                break;
            case "B":
                break;
            default:

        }
    }
}
