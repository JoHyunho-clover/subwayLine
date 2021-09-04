
//그냥 역목록과
//각 호선마다의 라인이 있어야한다.

import java.util.*;

public class LineRepository {

    //각 호선마다의 라인이 있어야한다.
    //그럼 각각 호선마다 LineRepository를 만들자.
    private List<Line> lines;

    public LineRepository() {
        this.lines = new ArrayList<>();
    }

    public void save(Line newline){
        lines.add(newline);
    }

    //이건 역목록일때 만 삭제 가능 즉 1번역관리에 해당.
    public void remove(String name){
        int i=0;
        for (Line line: lines) {
            if(line.getName()==name){
                lines.remove(i);
            }
            i++;
        }
    }

    //조회
    public void search(){
        for (Line line: lines) {
            System.out.println("[INFO] "+line.getName());
        }
    }
}
