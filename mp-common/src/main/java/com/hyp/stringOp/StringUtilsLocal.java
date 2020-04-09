package com.hyp.stringOp;

import com.hyp.constants.CollectionUtilsLocal;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by  on 2017/5/12.
 * <p>
 * Email 
 * <p>
 * Describe: 字符串工具类
 */
public class StringUtilsLocal extends org.apache.commons.lang3.StringUtils {

    private static final char SEPARATOR = '_';
    private static final String CHARSET_NAME = "UTF-8";
    private static  Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");


    /**
     * 获取混淆MD5签名用的随机字符串
     * @param length
     * @return
     */
    public  String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    /**
     * 转换为字节数组
     *
     * @param str
     * @return
     */
    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes(CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 转换为字节数组
     *
     * @param bytes
     * @return
     */
    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            return EMPTY;
        }
    }

    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inString(String str, String... strs) {
        if (str != null) {
            for (String s : strs) {
                if (str.equals(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 替换掉HTML标签方法
     */
    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }

    /**
     * 替换为手机识别的HTML，去掉样式及属性，保留回车。
     *
     * @param html
     * @return
     */
    public static String replaceMobileHtml(String html) {
        if (html == null) {
            return "";
        }
        return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
    }

    /**
     * 替换为手机识别的HTML，去掉样式及属性，保留回车。
     *
     * @param txt
     * @return
     */
    public static String toHtml(String txt) {
        if (txt == null) {
            return "";
        }
        return replace(replace(Encodes.escapeHtml(txt), "\n", "<br/>"), "\t", "&nbsp; &nbsp; ");
    }

    /**
     * 缩略字符串（不区分中英文字符）
     *
     * @param str    目标字符串
     * @param length 截取长度
     * @return
     */
    public static String abbr(String str, int length) {
        if (str == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int currentLength = 0;
            for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
                currentLength += String.valueOf(c).getBytes("GBK").length;
                if (currentLength <= length - 3) {
                    sb.append(c);
                } else {
                    sb.append("...");
                    break;
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String abbr2(String param, int length) {
        if (param == null) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        int n = 0;
        char temp;
        // 是不是HTML代码
        boolean isCode = false;
        // 是不是HTML特殊字符,如&nbsp;
        boolean isHTML = false;
        for (int i = 0; i < param.length(); i++) {
            temp = param.charAt(i);
            if (temp == '<') {
                isCode = true;
            } else if (temp == '&') {
                isHTML = true;
            } else if (temp == '>' && isCode) {
                n = n - 1;
                isCode = false;
            } else if (temp == ';' && isHTML) {
                isHTML = false;
            }
            try {
                if (!isCode && !isHTML) {
                    n += String.valueOf(temp).getBytes("GBK").length;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if (n <= length - 3) {
                result.append(temp);
            } else {
                result.append("...");
                break;
            }
        }
        // 取出截取字符串中的HTML标记
        String tempResult = result.toString().replaceAll("(>)[^<>]*(<?)",
                "$1$2");
        // 去掉不需要结素标记的HTML标记
        tempResult = tempResult
                .replaceAll(
                        "</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>",
                        "");
        // 去掉成对的HTML标记
        tempResult = tempResult.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>",
                "$2");
        // 用正则表达式取出标记

        Matcher m = p.matcher(tempResult);
        List<String> endHTML = new ArrayList();
        while (m.find()) {
            endHTML.add(m.group(1));
        }
        // 补全不成对的HTML标记
        for (int i = endHTML.size() - 1; i >= 0; i--) {
            result.append("</");
            result.append(endHTML.get(i));
            result.append(">");
        }
        return result.toString();
    }

    /**
     * 转换为Double类型
     */
    public static Double toDouble(Object val) {
        if (val == null) {
            return 0D;
        }
        try {
            return Double.valueOf(trim(val.toString()));
        } catch (Exception e) {
            return 0D;
        }
    }

    /**
     * 转换为Float类型
     */
    public static Float toFloat(Object val) {
        return toDouble(val).floatValue();
    }

    /**
     * 转换为Long类型
     */
    public static Long toLong(Object val) {
        return toDouble(val).longValue();
    }

    /**
     * 转换为Integer类型
     */
    public static Integer toInteger(Object val) {
        return toLong(val).intValue();
    }


    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase("hello_world") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase("hello_world") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase("hello_world") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 转换为JS获取对象值，生成三目运算返回结果
     *
     * @param objectString 对象串
     *                     例如：row.user.id
     *                     返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
     */
    public static String jsGetVal(String objectString) {
        StringBuilder result = new StringBuilder();
        StringBuilder val = new StringBuilder();
        String[] vals = split(objectString, ".");
        for (int i = 0; i < vals.length; i++) {
            val.append("." + vals[i]);
            result.append("!" + (val.substring(1)) + "?'':");
        }
        result.append(val.substring(1));
        return result.toString();
    }

    /**
     * 判断字符串是否为null 或者length==0
     *
     * @param s
     * @return 是返回 true 否 返回false
     */
    public static boolean isEmpty(String s) {
        if (null == s || s.trim().length() == 0) {
            return true;
        }
        return false;
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下划线
     * @param str
     * @return
     */
    public static String humpToLine(String str){
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    /**
     * 下划线转驼峰
     * @param str
     * @return
     */
    public static String lineToHump(String str){
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }



    private static Logger logger = Logger.getLogger(StringUtilsLocal.class);

    /**
     * 处理过长文本
     *
     * @param str 原文本
     * @param limit 需要显示的字数
     * @return 文本...
     */
    @Deprecated
    private static String subTextByLimit(String str, int limit) {
        byte[] datas = str.getBytes();
        int english = 0;
        for (byte b : datas) {
            if (b > 0 && b < 127) {
                english++;
            }
        }
        int validLength = str.length() - english / 2;

        if (limit < validLength) {
            int endIndex = 0;
            int chinese = 0;
            for (int i = 0; i < datas.length; i++) {
                if (datas[i] < 0) {
                    chinese++;
                }
                if (i + 1 == limit * 2) {
                    if (chinese % 2 == 0) {
                        endIndex = i + 1 - chinese / 2;
                    } else {
                        endIndex = i + 1 - (chinese + 1) / 2;
                    }
                    break;
                }
            }
            str = str.substring(0, endIndex) + "...";
        }
        return str;
    }

    /**
     * 描述: 判断字符串是否为空
     * @param str
     * @return
     * @since Ver 1.1
     */
    @Deprecated
    public static boolean isBlank(String str) {
        return StringUtilsLocal.isBlank(str);
        // return (null == str || "".equals(str.trim()) || "NULL".equalsIgnoreCase(str.trim()));
    }

    /**
     * <pre>
     * 描述：将List<String> 转换为sql In的参数 字符串
     * @return returnType：String
     */
    @Deprecated
    public static String listToSqlIn(List<String> collection) {
        if (collection == null || collection.size() == 0) {
            return "'未找到'";
        }
        StringBuilder result = new StringBuilder();
        result.append("'").append(CollectionUtilsLocal.joinUniqueIgnoreEmpty(collection, "','")).append("'");
        return result.toString();
    }

    /**
     * <pre>
     * 描述：校验字符串是否包含中文
     *
     * @param str
     * @return returnType：boolean
     */
    private static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * object转String 为空的转换为""
     *
     * @param object
     * @return
     */
    public static String valueOf(Object object) {
        return object == null ? "" : object.toString();
        // if (object != null) {
        // return object.toString() == "null" ? "" : object.toString();
        // }
        // return "";
    }

    /**
     * object转Double 为空的转换为0.0
     *
     * @param object
     * @return
     */
    public static Double parseDouble(Object object) {
        String value = valueOf(object);
        // TODO:try catch illegal format string
        // try {
        // Double.parseDouble(value);
        // } catch (NumberFormatException e) {
        // logger.error("Double.parseDouble exception, error: "+e.getMessage());
        // }
        return "".equals(value) ? 0.0D : Double.parseDouble(value);

        // String obj = (object == "") ? "0.0" : String.valueOf(object);
        // String value = (obj == "null") ? "0.0" : obj;
        // return Double.parseDouble(value);
    }

    /*
     * 毫秒转化为时分秒
     */
    public static String formatTime(long ms) {
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        String strDay = day < 10 ? "0" + day : "" + day; // 天
        String strHour = hour < 10 ? "0" + hour : "" + hour;// 小时
        String strMinute = minute < 10 ? "0" + minute : "" + minute;// 分钟
        String strSecond = second < 10 ? "0" + second : "" + second;// 秒
        String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;// 毫秒
        strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;

        return strHour + ":" + strMinute + ":" + strSecond;
    }

    public static String deleteCharAtLastOne(StringBuilder rid) {
        String str = "";
        if (rid.length() > 0) {
            str = rid.deleteCharAt(rid.length() - 1).toString();
        }
        return str;
    }

    // 将中文符号转换为英文
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375) {
                c[i] = (char) (c[i] - 65248);
            }
        }
        return new String(c);
    }

    /**
     * 返回单个字符串，若匹配到多个的话就返回第一个，方法与getSubUtil一样
     *
     * @param soap
     * @param rgex
     * @return
     */
    public static String getSubUtilSimple(String soap, String rgex) {
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            return m.group(1);
        }
        return "";
    }

    /**
     * 保留2位小数
     *
     * @param d1
     * @return
     */
    public static Double keepTwoDecimals(double d1) {
        if (Double.isNaN(d1) || Double.isInfinite(d1)) {
            return 0.0;
        }
        if (d1 == 0.0) {
            return d1;
        }
        BigDecimal b = new BigDecimal(d1);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 给oldRet补齐i位，用value补位
     *
     * @param oldRet
     * @param value
     * @param i
     * @return
     */
    public static String formatMakeUp(String oldRet, String value, int i) {
        if (oldRet.length() > i) {
            return oldRet;
        }
        StringBuilder ret = new StringBuilder();
        i = i - oldRet.length();
        for (int j = 0; j < i; j++) {
            ret.append(value);
        }
        ret.append(oldRet);
        return ret.toString();
    }

    /**
     * 向左补位
     *
     * @param origin 字符串或整数
     * @param size 补位后字符串总长度
     * @param padStr 补位字符
     * @return
     */
    public static String leftPad(Object origin, int size, String padStr) {
        if (origin != null && origin instanceof Integer) {
            /**
             * <pre>
             *     %s   字符串类型
             *     %c   字符类型
             *     %b   布尔类型
             *     %d   整数类型（十进制）
             *     %x   整数类型（十六进制）
             *     %o   整数类型（八进制）
             *     %f   浮点类型
             *     %a   十六进制浮点类型
             *     %e   指数类型
             *     %g   通用浮点类型（f和e类型中较短的）
             *     %h   散列码
             *     %%   百分比类型
             *     %n   换行符
             *     %tx  日期与时间类型（x代表不同的日期与时间转换符
             * </pre>
             */
            String fromat = String.format("%%%s%dd", padStr, size);
            return String.format(fromat, origin);
        }

        String str = origin == null ? "" : origin.toString();
        return org.apache.commons.lang3.StringUtils.leftPad(str, size, padStr);
    }

    /**
     * 获取登录客户端IP
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    logger.error("InetAddress.getLocalHost exception, error: " + e.getMessage());
                }
                ipAddress = inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * String保留两位小数
     *
     * @param value
     * @return
     */
    @Deprecated
    public static String formatValue(String value) {
        int num = value.indexOf(".");
        if (num > 0 && num < value.length() - 3) {
            value = value.substring(0, num + 3);
        }
        return value;
    }

    /**
     * 字符串前面补零
     *
     * @param code
     * @param num
     * @return
     */
    public static String zeroFill(String code, int num) {
        String res = "";
        if (StringUtilsLocal.isNotBlank(code)) {
            res = String.format("%0" + num + "d", Integer.parseInt(code));
        }
        return res;
    }


}
