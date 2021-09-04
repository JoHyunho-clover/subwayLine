import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StationRepository {
    //역목록
    private LinkedList<Station> stationlist;

    public LinkedList<Station> getinstance(){
        return stationlist;
    }

    public StationRepository() {
        stationlist=new LinkedList<>();
    }

    public void save(Station n1, Station n2){
        stationlist.addFirst(n1);
        stationlist.addLast(n2);
    }

    public void save(Station n1){
        stationlist.addFirst(n1);
    }

    public void save(int index, Station n1){
        stationlist.add(index,n1);
    }

    public void remove(String name){
        int i=0;
        Station s=serachAndGet(name);
        if(s==null){
            System.out.println("\n[ERROR] 삭제할 역이 없습니다.\n");
        }else{
            stationlist.remove(s);
            System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
        }
        /*
        for (Station station: stationlist) {
            if(station.getName().equals(name)){
                stationlist.remove(i);
                break;
            }
            if(i==stationlist.size()){
                System.out.println("\n[ERROR] 삭제할 역이 없습니다.\n");
            }
            i++;

        }*/
    }

    public void printall(){
        for (Station station: stationlist) {
            System.out.println("[INFO] "+ station.getName());
        }
    }

    public Station serachAndGet(String name){
        for (Station station: stationlist) {
            if(station.getName().equals(name)){
                return station;
            }

        }
        return null;
    }
}
