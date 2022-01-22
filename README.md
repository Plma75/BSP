# BSP
Blocking your minecraft server plugins to show.

[한국어 README](https://github.com/Plma75/BSP/blob/master/README-kr.md)

# Features
* Blocking your minecraft server plugins to show.
* Custom Events.

# Install
Install the BSP from [here](https://github.com/Plma75/BSP/releases)

Put the file in 'Server Folder/plugins/'

restart your server.

# Use Custom Event

Example:
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
