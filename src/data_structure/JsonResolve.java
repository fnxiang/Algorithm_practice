import java.util.HashMap;

public class JsonResolve {

    private HashMap<String, Object> resolve(String input){
        HashMap<String, Object> map = new HashMap<String, Object>();
        char[] char_list = input.toCharArray();
        for(int i=0;i<char_list.length;i++){
            if (char_list[i]=='{')
                map = resolveContent(i+1, char_list.length, char_list);
            break;
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "{  \"a\": \"b\", \"c\": {\"d\":\"\"e\"}";
        JsonResolve obj = new JsonResolve();
        System.out.println(obj.resolve(s));
    }


    private HashMap<String, Object> resolveContent(int i, int length, char[] list) {
        int sign = 0, start = 0,  val_length = -1;
        boolean flag = false;
        HashMap<String, Object> map = new HashMap<String, Object>();
        String key = "";
        Object value;
        for (int j = i; j < length; j++) {
            //
            if (list[j] == '"') {
                sign++;
                start = j;
                for (int n=start;n<length;n++,j++){
                    if(list[n]=='\\'){
                        n++;
                        j++;
                        val_length++;
                    }else if(list[n]=='"'){
                        sign++;
                    }
                    val_length++;

                    if (sign % 2 == 0&&!flag) {

                        key = resolveString(start, val_length, list);
                        val_length = -1;
                    } else if(sign % 2 == 0&&!flag){
                        value = resolveString(start, val_length, list);
                        val_length = -1;
                        map.put(key, value);
                    }
                }
            }else if(list[j] == '{'){
                start = j+1;
                for(int m=start;m<length;m++,j++){
                    val_length++;
                    if(list[m]=='}'){
                        value = resolveContent(start, m-start+1, list);
                        map.put(key, value);
                    }
                }
            }else if(list[j] == ':'||list[j] == ','){
                flag=!flag;
            }else if(list[j] == '['){
                start = j+1;
                for(int m=start;m<length;m++,j++){
                    val_length++;
                    if(list[m]==']'){
                        value = resolveContent(start, m-start+1, list);
                        map.put(key, value);
                    }
                }
            }else if(list[j] == '}'){
                return map;
            }

        }
        return map;
    }


    private int[] resolveList(int start, int length, char[] list){
        int[] val_list = new int[length/2+1];
        int count_ = 0;
        int val=0;
        for(int i=0;i<length;i++){
            if(list[i] >= '0' || list[i]<='9'){
                while(list[i]!=','){
                    val=val*10+list[++i];
                }
            }else if(list[i] == ','){
                val_list[count_] = val;
                count_++;
                val=0;
                continue;
            }
        }
        return val_list;
    }



    private String resolveString(int start, int length, char[] list){
        char[] c_list = new char[length];
        for(int i=start;i<length;i++){
            c_list[i] = list[i];
        }
        return new String(c_list);
    }



}
