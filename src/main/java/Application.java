import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String args[]){
        Boolean value=true;
        Scanner scan =new Scanner(System.in);

        //역목록. 초기화진행.
        StationRepository stationRepository=stationlistinit();

        //역목록은 저장소를 따로 가지고 있는것으로 등록되어있는 걸 토대로 중복X 하게 들어가야한다.
        //역목록에 대한 것.
        StationControll s= new StationControll(stationRepository);

        //지하철 노선으로 2호선, 3호선, 신분당선이 등록되어 있다 밑의 초기화함수를 통해 return;
        LineAndStation allLines=init(stationRepository);
        //노선관리
        LineControll d=new LineControll(allLines,stationRepository);
        //2번째 인자로 역목록에 등록되어있는것을 가져와서 중복검사 및 등록안되어있는거 등록.

        //구간관리
        StageControll f=new StageControll(allLines);
        //지하철노선도 출력
        LineAndStationController g= new LineAndStationController(allLines);

        String select;
        String subselect;
        while(value){
            System.out.println("## 메인 화면");
            System.out.println("1. 역 관리");
            System.out.println("2. 노선 관리");
            System.out.println("3. 구간 관리 ");
            System.out.println("4. 지하철 노선도 출력");
            System.out.println("Q. 종료");
            System.out.println("");

            System.out.println("## 원하는 기능을 선택하세요.");
            select=scan.next();
            switch(select){
                case "1":
                    System.out.println("\n## 역 관리 화면");
                    System.out.println("1. 역 등록");
                    System.out.println("2. 역 삭제");
                    System.out.println("3. 역 조회 ");
                    System.out.println("B. 돌아가기\n");
                    System.out.println("## 원하는 기능을 선택하세요.");
                    subselect=scan.next();
                    s.choice(subselect);
                    break;
                case "2":
                    System.out.println("\n## 노선 관리 화면");
                    System.out.println("1. 노선 등록");
                    System.out.println("2. 노선 삭제");
                    System.out.println("3. 노선 조회 ");
                    System.out.println("B. 돌아가기\n");
                    System.out.println("## 원하는 기능을 선택하세요.");
                    subselect=scan.next();
                    d.choice(subselect);
                    break;
                case "3":
                    System.out.println("\n## 구간 관리 화면");
                    System.out.println("1. 구간 등록");
                    System.out.println("2. 구간 삭제");
                    System.out.println("B. 돌아가기\n");
                    System.out.println("## 원하는 기능을 선택하세요.");
                    subselect=scan.next();
                    f.choice(subselect);
                    break;
                case "4":
                    System.out.println("\n## 지하철 노선도");
                    g.prinall();
                    break;
                case "Q":
                    value = false;
                    break;
                default:
                    System.out.println("[ERROR] 선택할 수 없는 기능입니다.\n");
                    break;
            }
        }

    }
    public static LineAndStation init(StationRepository stationRepository){
        LineAndStation allLines=new LineAndStation();

        allLines.save(new Line("2호선"),stationRepository.serachAndGet("교대역"),
                stationRepository.serachAndGet("역삼역"));
        allLines.save("2호선",stationRepository.serachAndGet("강남역"),1);

        allLines.save(new Line("3호선"),stationRepository.serachAndGet("교대역"),
                stationRepository.serachAndGet("매봉역"));
        allLines.save("3호선",stationRepository.serachAndGet("남부터미널역"),1);
        allLines.save("3호선",stationRepository.serachAndGet("양재역"),2);

        allLines.save(new Line("신분당선"),stationRepository.serachAndGet("강남역"),
                stationRepository.serachAndGet("양재시민의숲역"));
        allLines.save("신분당선",stationRepository.serachAndGet("양재역"),2);
        return allLines;
    }

    public static StationRepository stationlistinit(){
        StationRepository stationRepository=new StationRepository();
        stationRepository.save(new Station("교대역"));
        stationRepository.save(new Station("강남역"));
        stationRepository.save(new Station("역삼역"));
        stationRepository.save(new Station("남부터미널역"));
        stationRepository.save(new Station("양재역"));
        stationRepository.save(new Station("양재시민의숲역"));
        stationRepository.save(new Station("매봉역"));
        return stationRepository;
    }
}
