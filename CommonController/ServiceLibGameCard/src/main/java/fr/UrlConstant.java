package fr;

public class UrlConstant {

    public final static int PortUser = 9388;
    public final static int PortTransaction = 9389;
    public final static int PortCard = 9390;
    public final static int PortGame = 9391;
    public final static String BaseUrl = "http://localhost";

    public static String getUserUrlPath()
    {
        return BaseUrl + ':' + PortUser;
    }

    public static String getTransactionUrlPath()
    {
        return BaseUrl + ':' + PortTransaction;
    }
    public static String getCardUrlPath()
    {
        return BaseUrl + ':' + PortCard;
    }
    public static String getGameUrlPath()
    {
        return BaseUrl + ':' + PortGame;
    }
}