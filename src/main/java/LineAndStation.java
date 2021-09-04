import java.util.HashMap;
import java.util.Map;

public class LineAndStation {
    LineRepository lineRepository= new LineRepository();
    StationRepository stationRepository;
    private Map<String,StationRepository> map=new HashMap<>();

    public Map<String,StationRepository> getinstance(){
        return map;
    }

    public LineAndStation() {
        /*
        lineRepository.save(new Line("2호선"));
        lineRepository.save(new Line("3호선"));
        lineRepository.save(new Line("신분당선"));

        map.put("2호선",);
        map.put("3호선",);
        map.put("신분당선호선",);
    */
    }

    public void save(Line line,Station n1, Station n2){
        stationRepository=new StationRepository();
        map.put(line.getName(),stationRepository);
        lineRepository.save(line);
        map.get(line.getName()).save(n1,n2);
    }


    public void save(String name,Station n1, int index){
        for (String oldname: map.keySet()) {
            if(name==oldname){
                map.get(name).save(index,n1);
            }
        }
    }

    public void search(){
        for (String name: map.keySet()) {
            System.out.println("[INFO] "+ name);
        }
    }

    public void remove(String name){
        lineRepository.remove(name);
        map.remove(name);
    }

    public void remove(String nameLine, String station){
        map.get(nameLine).remove(station);
    }

}
