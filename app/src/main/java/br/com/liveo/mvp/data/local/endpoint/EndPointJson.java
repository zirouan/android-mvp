package br.com.liveo.mvp.data.local.endpoint;

/**
 * Created by rudsonlima on 10/20/17.
 */

public class EndPointJson {

    //region Methods User
    static final String USERS_JSON_SUCCESS = "{\n" +
            "\t\"page\": 1,\n" +
            "\t\"per_page\": 3,\n" +
            "\t\"total\": 12,\n" +
            "\t\"total_pages\": 4,\n" +
            "\t\"data\": [{\n" +
            "\t\t\t\"id\": 1,\n" +
            "\t\t\t\"first_name\": \"George\",\n" +
            "\t\t\t\"last_name\": \"Bluth\",\n" +
            "\t\t\t\"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 2,\n" +
            "\t\t\t\"first_name\": \"Janet\",\n" +
            "\t\t\t\"last_name\": \"Weaver\",\n" +
            "\t\t\t\"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": 3,\n" +
            "\t\t\t\"first_name\": \"Emma\",\n" +
            "\t\t\t\"last_name\": \"Wong\",\n" +
            "\t\t\t\"avatar\": \"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";

    static final String USERS_JSON_FAIL = "{\n" +
            "        \"errorMessage\": \"error fetch users\"\n" +
            "    }";
    //endregion
}
