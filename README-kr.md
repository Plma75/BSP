# BSP
서버 플러그인 목록을 다른 일반 유저분들에게 보이지 않게합니다.

[ENGLISH README](https://github.com/Plma75/BSP/blob/master/README.md)

# 기능
* 당신의 서버의 플러그인 목록을 일반 유저분들에게 보이지 않게합니다.
* 커스텀 이벤트로 여러 기능들을 자신이 원하는 대로 만들수 있습니다.

# 설치
BSP 플러그인을 [여기](https://github.com/Plma75/BSP/releases) 에서 설치해주세요.

다운로드 한 파일을 '서버폴더/plugins/' 에 넣어주세요.

당신의 서버를 다시 시작해주세요.

# 커스텀 이벤트

예시:
```csharp
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
public class Test implements Listener {
    @EventHandler
    public void blockPluginEvent(BlockPluginEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Hey " + player.getDisplayName() + " please be careful.");
    }
}
```
