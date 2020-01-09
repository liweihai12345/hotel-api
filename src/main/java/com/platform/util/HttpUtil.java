package com.platform.util;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class HttpUtil {
    /**
     * 定义编码格式 UTF-8
     */
    public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";
    /**
     * 定义编码格式 GBK
     */
    public static final String URL_PARAM_DECODECHARSET_GBK = "GBK";
    private static final String URL_PARAM_CONNECT_FLAG = "&";
    private static final String EMPTY = "";
    private static MultiThreadedHttpConnectionManager connectionManager = null;
    private static int connectionTimeOut = 25000;
    private static int socketTimeOut = 25000;
    private static int maxConnectionPerHost = 20;
    private static int maxTotalConnections = 20;
    private static HttpClient client;
    // 当前登录的人
    static Cookie[] cookies = null;
    // 登录URL
    static String loginURL = "/admin/login.do";
    // 登录账户
    static String loginUserName = "admin";
    static String loginPassword = "admin";
    static {
        connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
        connectionManager.getParams().setSoTimeout(socketTimeOut);
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
        connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
        client = new HttpClient(connectionManager);
    }
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    /**
     * POST方式提交数据
     *
     * @param url    待请求的URL
     * @param params 要提交的数据
     * @param enc    编码
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static String URLPost(String url, Map<String, Object> params, String enc) {
        String response = EMPTY;
        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            //将表单的值放入postMethod中
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                Object value = params.get(key);
                postMethod.addParameter(key, String.valueOf(value));
            }
            //执行postMethod
            int statusCode = client.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK) {
                response = postMethod.getResponseBodyAsString();
            } else {
                System.out.println("响应状态码 = " + postMethod.getStatusCode());
            }
        } catch (HttpException e) {
            System.out.println("发生致命的异常，可能是协议不对或者返回的内容有问题"+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("发生网络异常"+e.getMessage());
            e.printStackTrace();
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }
        }
        return response;
    }
    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }
    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    /**
     * GET方式提交数据
     *
     * @param url    待请求的URL
     * @param params 要提交的数据
     * @param enc    编码
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static String URLGet(String url, Map<String, String> params, String enc) {
        String response = EMPTY;
        GetMethod getMethod = null;
        StringBuffer strtTotalURL = new StringBuffer(EMPTY);
        if (strtTotalURL.indexOf("?") == -1) {
            strtTotalURL.append(url).append("?").append(getUrl(params, enc));
        } else {
            strtTotalURL.append(url).append("&").append(getUrl(params, enc));
        }
        System.out.println("GET请求URL = \n" + strtTotalURL.toString());
        try {
            getMethod = new GetMethod(strtTotalURL.toString());
            getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            //执行getMethod
            int statusCode = client.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK) {
                response = getMethod.getResponseBodyAsString();
            } else {
                System.out.println("响应状态码 = " + getMethod.getStatusCode());
            }
        } catch (HttpException e) {
            System.out.println("发生致命的异常，可能是协议不对或者返回的内容有问题"+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("发生网络异常"+e.getMessage());
            e.printStackTrace();
        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();
                getMethod = null;
            }
        }
        return response;
    }
    /**
     * 据Map生成URL字符串
     *
     * @param map      Map
     * @param valueEnc URL编码
     * @return URL
     */
    private static String getUrl(Map<String, String> map, String valueEnc) {
        if (null == map || map.keySet().size() == 0) {
            return (EMPTY);
        }
        StringBuffer url = new StringBuffer();
        Set<String> keys = map.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext(); ) {
            String key = it.next();
            if (map.containsKey(key)) {
                String val = map.get(key);
                String str = val != null ? val : EMPTY;
                try {
                    str = URLEncoder.encode(str, valueEnc);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                url.append(key).append("=").append(str).append(URL_PARAM_CONNECT_FLAG);
            }
        }
        String strURL = EMPTY;
        strURL = url.toString();
        if (URL_PARAM_CONNECT_FLAG.equals(EMPTY + strURL.charAt(strURL.length() - 1))) {
            strURL = strURL.substring(0, strURL.length() - 1);
        }
        return (strURL);
    }
    /**
     * POST方式提交数据
     *
     * @param url     待请求的URL
     * @param params  要提交的数据
     * @param enc     编码
     * @param session 带session
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static String URLPost(String url, Map<String, Object> params, String enc, boolean session) {
        String response = EMPTY;
        PostMethod postMethod = null;
        if (!session) {
            return URLPost(url, params, enc);
        }
        try {
            postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            //将表单的值放入postMethod中
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                Object value = params.get(key);
                postMethod.addParameter(key, String.valueOf(value));
            }
            if (null != cookies) {
                client.getState().addCookies(cookies);
            } else {
                getAuthCookie(url, enc);
                client.getState().addCookies(cookies);
            }
            //执行postMethod
            int statusCode = client.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK) {
                response = postMethod.getResponseBodyAsString();
            } else {
                System.out.println("响应状态码 = " + postMethod.getStatusCode());
            }
        } catch (HttpException e) {
            System.out.println("发生致命的异常，可能是协议不对或者返回的内容有问题"+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("发生网络异常"+e.getMessage());
            e.printStackTrace();
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }
        }
        return response;
    }
    /**
     * 获取session
     *
     * @param url 待请求的URL
     * @param enc 编码
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static void getAuthCookie(String url, String enc) {
        PostMethod postMethod = null;
        try {
            Object[] ipPort = getIpPortFormURL(url);
            String ip = (String) ipPort[0];
            int port = (Integer) ipPort[1];
            String logUrl = "http://" + ip + ":" + port + loginURL;
            postMethod = new PostMethod(logUrl);
            postMethod.addParameter("username", loginUserName);
            postMethod.addParameter("password", loginPassword);
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            //执行postMethod
            int statusCode = client.executeMethod(postMethod);
            // 查看 cookie 信息
            CookieSpec cookiespec = CookiePolicy.getDefaultSpec();
            cookies = cookiespec.match(ip, port, "/", false, client.getState().getCookies());
            System.out.println("响应状态码 = " + postMethod.getStatusCode());
        } catch (HttpException e) {
            System.out.println("发生致命的异常，可能是协议不对或者返回的内容有问题"+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("发生网络异常"+e.getMessage());
            e.printStackTrace();
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }
        }
    }
    /**
     * 解析URL的端口和ip
     *
     * @param URL
     * @return
     */
    public static Object[] getIpPortFormURL(String URL) {
        Object[] ip_port = new Object[2];
        try {
            java.net.URL url = new URL(URL);
            ip_port[0] = url.getHost();
            ip_port[1] = url.getPort() != -1 ? url.getPort() : 80;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ip_port;
    }
    public static void setLoginPassword(String loginPassword) {
        HttpUtil.loginPassword = loginPassword;
    }
    public static void setLoginUserName(String loginUserName) {
        HttpUtil.loginUserName = loginUserName;
    }
    public static void setLoginURL(String loginURL) {
        HttpUtil.loginURL = loginURL;
    }
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://blog.csdn.net/zhujianlin1990");
        System.out.println(url.getHost());
        System.out.println(url.getPort());
    }
}
