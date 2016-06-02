package fr.Meporg;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable(){
		getLogger().info("Meporg : ON");
        getServer().getPluginManager().registerEvents(this, this);  
	}
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer(); // On recupère le joueur
        if(player.hasPlayedBefore()){ // On regarde si le joueurs c'est déjà connecter
            event.setJoinMessage("§e" + event.getPlayer().getName() + "§6 vient de se connecter"); // Si l'utilisateur c'est déjà connecter avant. On change juste le message ("Player" Join the game)
        }
        else // Sinon on fait autre chose pour les nouveau utilisateur (Phrase de bienvenue et le livre des règles)
        {
            event.setJoinMessage("§6Bienvenue à §e" + event.getPlayer().getName() + "§6 qui rejoins notre serveur !"); // Utilisateur qui se connecte pour la première fois sur le serveur.
        ItemStack livre = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta meta = (BookMeta) livre.getItemMeta();
        meta.setTitle("§6Règles du serveur SLCraft"); // 1er Phrases quand on passe la souris sur le livre
        meta.setAuthor("SLCraft Staff"); // 2ème Phrases quand on passe la souris sur le livre
        meta.setLore(Arrays.asList("§3Ce livre contient", "§ales règles du serveur")); // 3ème Phrases quand on passe la souris sur le livre
        meta.setPages(Arrays.asList(
                "§4§lSommaire :§0 \n \n n°1 : §cLe grief §0\n n°2 : §cLe vol§0 \n n°3 : §cLe cheat§0 \n n°4 : §cL'usebug §0\n n°5 : §cSystèmes automatiques§0 \n n°6 : §cPortail vers le nether§0",
                "§2§lArticle 1 : Le grief§0 \n \n Il est interdit de détruire ou de modifier les créations appartenant à autrui. Cela s'appelle le grief et un tel acte est puni d'un banissement définitif. ",
                "§2§lArticle 2 : Le vol§0 \n \n Il est interdit de voler, que ce soit dans les coffres des autres, même s'ils ne sont pas protégés ou bien en ramassant les objets d'un joueur sur le sol.",
                "§2§lArticle 3 : Le cheat§0 \n \n Toute forme de triche est interdite. Cela comprend les mods, en effet, ils permettent d'avoir un avantage sur les autres joueurs. Toute personne trichant sera bannie définitivement.",
                "§2§lArticle 4 : L'usebug§0 \n \n Tous les bugs, qu'ils proviennent de Minecraft ou de Minebox, permettant de générer des ressources ou d'exploiter d'autres failles qui relèvent du cheat, sont interdits.",
                "§2§lArticle 5 : Systèmes automatiques§0 \n \n Tout système permettant de générer des items ou de l’expérience automatiquement, comme les tours à mobs, est interdit.",
                "§2§lArticle 6 : Les portails privés vers le nether§0 \n \n Il est défendu de créer de portails vers le nether. Empruntez le portail dans la salle des portail du spawn.",
                "§4§lJ'aime les licornes."));
        livre.setItemMeta(meta);
        event.getPlayer().getInventory().addItem(livre); // Comme c'est la première fois qu'il se connecte on lui donne le livre des règles.
        }
    }
	@EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        event.setQuitMessage("§e" + event.getPlayer().getName() + "§6 vient de se déconnecter."); // On change le message de déconnexion !
    }

}
