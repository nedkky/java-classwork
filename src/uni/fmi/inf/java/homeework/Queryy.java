package uni.fmi.inf.java.homeework;

import java.util.ArrayList;

/**
 * @author Недко Господинов
 */

public class Query {

    public static ArrayList<String> userActualRequest = new ArrayList<String>();

    /**
     * @param userRequest Потребителска заявка!
     */
    public static void processUserRequest(String userRequest) {

        if (userRequest.substring(0, 6).equals("SELECT")) {
            if (userRequest.indexOf("@") == -1) {
                userRequest = userRequest.substring(userRequest.indexOf("SELECT") + 6);
                if (userRequest.startsWith("{SPECIAL_PROPERTY}")) specialPropertyFiltering(userRequest);
                else userActualRequest.add(userRequest);
            } else {
                userRequest = userRequest.substring(6);
                if (userRequest.startsWith("{SPECIAL_PROPERTY}")) {
                    specialPropertyFiltering(userRequest);
                } else {
                    userActualRequest.add(userRequest.substring(0, userRequest.indexOf(']') + 1));
                    userRequest = userRequest.substring(userRequest.indexOf("]") + 1);
                    while (userRequest.indexOf("]") != -1) {
                        if (userRequest.startsWith("@{SPECIAL_PROPERTY}")) {
                            specialPropertyFiltering(userRequest);
                            break;
                        }
                        userActualRequest.add(userRequest.substring(1, userRequest.indexOf(']') + 1));
                        userRequest = userRequest.substring(userRequest.indexOf("]") + 1);
                    }
                }
            }
        } else {
            return;
        }
        searchInDatabase();
    }

    private static void specialPropertyFiltering(String userRequest) {
        userRequest = userRequest.substring(userRequest.indexOf("::") + 2);
        if (userRequest.startsWith("{SALARY}=") || userRequest.startsWith("{PENSION}=")) {
            userActualRequest.add(userRequest);
        } else if (userRequest.startsWith("{KID}=")) {
            while (userRequest.contains("KFNAME") || userRequest.contains("KLNAME") || userRequest.contains("KAGE")) {
                int pos = 0;
                if (userRequest.contains("KFNAME")) {
                    pos = userRequest.indexOf("{KFNAME}=[");
                    userActualRequest.add(userRequest.substring(pos, userRequest.indexOf("]") + 1));
                    userRequest = userRequest.replace(userRequest.substring(pos, userRequest.indexOf("]") + 1), "");
                }
                if (userRequest.contains("KLNAME")) {
                    pos = userRequest.indexOf("{KLNAME}=[");
                    userActualRequest.add(userRequest.substring(pos, userRequest.indexOf("]") + 1));
                    userRequest = userRequest.replace(userRequest.substring(pos, userRequest.indexOf("]") + 1), "");
                }
                if (userRequest.contains("KAGE")) {
                    pos = userRequest.indexOf("{KAGE}=[");
                    userActualRequest.add(userRequest.substring(pos, userRequest.indexOf("]") + 1));
                    userRequest = userRequest.replace(userRequest.substring(pos, userRequest.indexOf("]") + 1), "");
                }
                if (userRequest.contains("[@@]")) {
                    userRequest = userRequest.replace("[@@]", "");
                }
            }
        }
    }

    /**
     * Търсене на базата данни (метод).
     */
    private static void searchInDatabase() {
        boolean userRequestFound = true;
        ArrayList<String> dataBaseV = Database.getValidatedDatabase();
        ArrayList<String> dataBaseF = Database.getFilteredDatabase();
        for (int i = 0; i < dataBaseV.size(); i++) {
            for (int x = 0; x < userActualRequest.size(); x++) {
                if (dataBaseV.get(i).indexOf(userActualRequest.get(x)) == -1) {
                    userRequestFound = false;
                }
            }
            if (userRequestFound) {
                System.out.println(dataBaseF.get(i));
            }
            userRequestFound = true;

        }
        userActualRequest.clear();
    }
}