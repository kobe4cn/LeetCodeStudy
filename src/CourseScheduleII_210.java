import java.util.*;

//210. 课程表 II
public class CourseScheduleII_210 {
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        Map<Integer, List<Integer>> maps=new HashMap<>();
//
//       if(canFinish(numCourses,prerequisites,maps)){
//           Iterator<Integer> iterator=maps.keySet().iterator();
//           while(iterator.hasNext()){
//               Integer key=iterator.next();
//               map.
//           }
//
//
//       }else{
//           return new int[0];
//        }
//
//    }

    public boolean canFinish(int numCourses, int[][] prerequisites,Map<Integer, List<Integer>> maps) {
        Map<Integer, List<Integer>> map=maps;
        for (int[] course:prerequisites
        ) {

            //判断是否有错误的课程
            if(course[0]==course[1]){
                return false;
            }
            if(map.containsKey(course[0])){
                List<Integer> nextcourse=new ArrayList<>();
                nextcourse=map.get(course[0]);
                Queue<Integer> queue=new LinkedList<>(nextcourse);
                while(!queue.isEmpty()){
                    int temp=queue.remove();
                    if(map.containsKey(temp)){
                        queue.addAll(map.get(temp));
                    }
                    if(temp==course[1]){
                        return false;
                    }
                }
            }
            //加入进去
            if(map.containsKey(course[1])){
                map.get(course[1]).add(course[0]);

            }else {
                //从来都不存在这个课程安排就直接新增
                List<Integer> nextcourse=new ArrayList<>();
                nextcourse.add(course[0]);
                map.put(course[1], nextcourse);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Map<List<Integer>,List<Integer>> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        list1.add(0);
        list.add(1);
        list.add(2);
        map.put(list,list1);

        List<Integer> list2=new ArrayList<>();
        List<Integer> list3=new ArrayList<>();
        list2.add(3);
        list3.add(1);
        map.put(list2,list3);

        List<Integer> test=new ArrayList<>();
        List<Integer> test1=new ArrayList<>();
        test.add(3);
        System.out.println(map.containsKey(test));



    }
}
