package WORK10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RaceTest {
    public static void main(String[] args) {
        RaceTime record = new RaceTime();
        record.add(new Date(100));
        System.out.println(record);
        //尝试修改开始时间
        Date st = record.get(0);
        st.setTime(114514);
        System.out.println("修改时间为："+st);
        //记录没有改变
        System.out.println(record);
    }
}

class RaceTime {
    private List<Date> end;
    public RaceTime(){
        end = new ArrayList<>();
    }
    public void add(Date e){
        if(e == null)
            throw new NullPointerException();
        end.add(new Date(e.getTime()));
    }
    public Date get(int i){
        if(i < 0 || i >= end.size())
            throw new IllegalArgumentException();
        return new Date(end.get(i).getTime());
    }
    @Override
    public String toString(){return "end time: "+end.toString();}
}
