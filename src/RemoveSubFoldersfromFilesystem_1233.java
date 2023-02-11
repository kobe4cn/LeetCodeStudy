import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//1233. 删除子文件夹
public class RemoveSubFoldersfromFilesystem_1233 {

    public List<String> removeSubfolders(String[] folder) {
        List<String> result=new ArrayList<>();
        List<String> list=new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            String folders=folder[i];
            int lastIndexOf = folders.lastIndexOf("/");
            if(lastIndexOf!=0){
                String substring = folders.substring(0, lastIndexOf);
                if(!list.contains(substring)) {
                    list.add(folders);
                }
            }else{
                list.add(folders);
            }
        }

        for (int i = 0; i < folder.length; i++) {
            String folders=folder[i];
            int lastIndexOf = folders.lastIndexOf("/");
            if(lastIndexOf!=0){
                String substring = folders.substring(0, lastIndexOf);
                if(!(list.stream().filter(s -> substring.startsWith(s)).count()>0)){
                    result.add(folders);
                }
            }else{
                result.add(folders);
            }
        }
        return result;
    }


    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] folder = stringToStringArray(line);

            List<String> ret = new RemoveSubFoldersfromFilesystem_1233().removeSubfolders(folder);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}
