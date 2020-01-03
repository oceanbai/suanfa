/* 版权所有(C)，OceanBai，2020，所有权利保留。
 *
 * 项目名：	alibaba
 * 文件名：	TwoStringEquals
 * 模块说明：
 * 修改历史：
 * 2020/1/2 - ocean - 创建。
 */

package alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ocean
 * @date 2020/1/2
 */
public class TwoStringEquals {
    public boolean backspaceCompare(String S, String T) {
        return getRealString(S).equals(getRealString(T));
    }

    public String getRealString(String value) {
        List<String> list = new ArrayList<>(value.length());
        for (int i = 0; i < value.length(); i++) {
            if ("#".equals(value.charAt(i) + "")) {
                if (list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(value.charAt(i) + "");
            }
        }
        StringBuilder sb = new StringBuilder(list.size());
        for (String charValue : list) {
            sb.append(charValue);
        }
        return sb.toString();
    }

    /**----------------------*/
//    public int myAtoi(String str) {
//        StringBuilder sb = new StringBuilder(str.length());
//        boolean isHaveSymbol = false;
//        for(int i = 0 ; i< str.length() ; i++){
//            if(" ".equals(str.charAt(i) + "")){
//                continue;
//            }
//            if(!isHaveSymbol && ( "-".equals(str.charAt(i) + "") || "-".equals(str.charAt(i) + ""))){
//                sb.append(str.charAt(i));
//                isHaveSymbol = true;
//                continue;
//            }
//            if(!Character.isDigit(str.charAt(i))){
//                break;
//            }else{
//                sb.append(str.charAt(i));
//            }
//        }
//        if(sb.length() == 0){
//            return 0;
//        }else if ("-".equals(sb.charAt(0) + "")) {
//
//        }
//    }
}
