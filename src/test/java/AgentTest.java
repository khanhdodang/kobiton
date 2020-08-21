import com.kobiton.Agent;

public class AgentTest {
    private static String username;
    private static String apiKey;
    private static String hostName = "api.kobiton.com";

    public static void main(String[] args) {
        username = System.getenv("KOBITON_USERNAME") != null ? System.getenv("KOBITON_USERNAME") : username;
        apiKey = System.getenv("KOBITON_API_KEY") != null ? System.getenv("KOBITON_API_KEY") : apiKey;
        hostName = System.getenv("KOBITON_AUTOMATION_HOSTNAME") != null ? System.getenv("KOBITON_AUTOMATION_HOSTNAME") : hostName;
        if (username == null || apiKey == null) {
            System.err.println("Your UserName or API Key are empty.");
        }

        boolean flag = Agent.waitForDeviceOnline(hostName, username, apiKey, "cloud", "LGD722J46ab679a", 120);
        System.out.println("Does the device exist? " + flag);
    }
}
