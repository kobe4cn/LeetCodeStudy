import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Meeting implements Comparable {
    public static void main(String[] args) {
        //int[][] temp={{0,30},{5,10},{15,20}};
        // int[][] temp={{7,10},{2,4}};
        int[][] temp={{1,4},{2,8},{5,7},{5,9},{2,6}};
        System.out.println(minMeetingRooom(temp));
        //System.out.println(minMeetingRooom(temp));
    }
    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Object o) {
        Meeting meeting = (Meeting) o;
        return this.startTime - meeting.startTime;
    }


    public static int minMeetingRooom(int[][] intervals){
        List<TreeSet<Meeting>> meetingRooms=new ArrayList<>();
        int i=0;
        while(intervals.length>0){
            int[] meetingtime=intervals[0];
            Meeting meeting=new Meeting(meetingtime[0],meetingtime[1]);
            if(meetingRooms.size()==0){
                //第一个会议进来需要创建会议室
                TreeSet<Meeting> meetingRoom=new TreeSet<>();
                meetingRoom.add(meeting);
                meetingRooms.add(meetingRoom);
                intervals=deleteArray(intervals,0);
            }else{
                int j=0;
                boolean findmeetingroom=false;
                while(j<meetingRooms.size()){
                    TreeSet<Meeting> meetingRoom=meetingRooms.get(j);
                    if(checkMeetingAvailable(meetingRoom,meeting)){
                        meetingRoom.add(meeting);
                        meetingRooms.set(j,meetingRoom);
                        intervals=deleteArray(intervals,0);
                        findmeetingroom=true;
                        break;
                    }
                    j++;
                }
                if(!findmeetingroom){
                    //如果现有的会议室都不匹配,创建一个新的会议室
                    TreeSet<Meeting> meetingRoom=new TreeSet<>();
                    meetingRoom.add(meeting);
                    meetingRooms.add(meetingRoom);
                    intervals=deleteArray(intervals,0);
                }
            }
            i++;
        }
        return meetingRooms.size();

    }
    // true 可以使用

    public static boolean checkMeetingAvailable(TreeSet<Meeting> meetingTreeSet,Meeting meeting) {
        if(meetingTreeSet.size()>0) {
            Meeting prveMeeting = meetingTreeSet.floor(meeting);
            Meeting afterMeeting = meetingTreeSet.higher(meeting);
            if(afterMeeting==null) {
                if(prveMeeting.getEndTime()<=meeting.getStartTime()){
                    return true;
                }
            }else if(prveMeeting==null){
                if(afterMeeting.getStartTime()>=meeting.getEndTime()){
                    return true;
                }
            }
            else{
                if (prveMeeting.getEndTime() <= meeting.getStartTime()
                        && afterMeeting.getStartTime() >= meeting.getEndTime()) {
                    return true;
                }
            }
        }
        return false;
    }



    public static int[][] deleteArray(int[][] intervals,int targetIndex){
        int len=intervals.length;
        if(len>1) {
            int[][] newArray = new int[len - 1][2];

            int i = 0;

            if (targetIndex == 0) {
                //如果删除数组第一位，将从第二个位置对新数组负值
                i++;
                while (i < len) {
                    newArray[i - 1] = intervals[i];
                    i++;
                }

            } else if (targetIndex == len - 1) {
                while (i<len-1){
                    newArray[i]=intervals[i];
                    i++;
                }
            }else{
                while(i< newArray.length){
                    if(i==targetIndex){
                        while(i+1<len){
                            newArray[i]=intervals[i+1];
                            i++;
                        }
                        break;
                    }else{
                        newArray[i]=intervals[i];
                    }
                    i++;
                }
            }

            return newArray;
        }else{
            return new int[0][0];
        }
    }
}

