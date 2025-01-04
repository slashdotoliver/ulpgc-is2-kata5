package es.ulpgc.kata5.architecture.control.io.randomuserapi;

import com.google.gson.Gson;
import es.ulpgc.kata5.architecture.control.io.Provider;
import es.ulpgc.kata5.architecture.control.io.UserAdapter;
import es.ulpgc.kata5.architecture.control.pojo.randomuserapi.RUResponse;
import es.ulpgc.kata5.architecture.control.pojo.randomuserapi.RUUser;
import es.ulpgc.kata5.architecture.model.User;
import org.jsoup.Jsoup;

import java.io.IOException;

public class RUUserProvider implements Provider<User> {

    private static final String RANDOMUSER_API_URL = "https://randomuser.me/api";
    private static final Gson GSON = new Gson();
    private static final UserAdapter<RUUser> USER_ADAPTER = new RUUserAdapter();;

    @Override
    public User retrieve() throws IOException {
        return USER_ADAPTER.from(
                GSON.fromJson(Jsoup.connect(RANDOMUSER_API_URL).ignoreContentType(true).get().text(), RUResponse.class)
                        .results()
                        .getFirst()
        );
    }
}
