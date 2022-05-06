import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget_797 {
    public static void main(String[] args) {
        //int[][] graph={{4,3,1},{3,2,4},{3},{4},{}};

        //int[][] graph={{1,2},{3},{3},{}};
       // int[][] graph={{4,3,1},{3,2,4},{},{4},{}};
        int[][] graph={{2},{},{1}};
        System.out.println(allPathsSourceTarget(graph));
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int max=graph.length;
        List<List<Integer>> pathsList=new ArrayList<>();
        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> list=new ArrayList<>();
            list.add(0);
            int temp=graph[0][i];
            list.add(temp);
            getPath(graph,temp,list,max,pathsList);
        }

        return pathsList;
    }

    public static void getPath(int[][] graph,int temp,List<Integer> list,int max,List<List<Integer>> pathsList){

        if(temp<max){
            if(graph[temp].length==0){
                if(list.get(list.size()-1)==max-1)
                    pathsList.add(list);
            }
            for(int i=0;i<graph[temp].length;i++){
                List<Integer> newlist=new ArrayList<>(list);
                int tempkey=graph[temp][i];
                newlist.add(tempkey);
                if(tempkey<max && graph[tempkey].length==0){
                    if(newlist.get(newlist.size()-1)==max-1)
                        pathsList.add(newlist);
                    else if(newlist.size()>max-1){
                        pathsList.add(newlist.subList(0,max-1));
                    }
                }else {
                    getPath(graph, tempkey, newlist, max, pathsList);
                }
            }

        }

    }

}
