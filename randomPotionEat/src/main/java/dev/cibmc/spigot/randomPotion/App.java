package dev.cibmc.spigot.randomPotion;

import java.util.Random;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class App extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getLogger().info("random potion turned on");
        this.getServer().getPluginManager().registerEvents(this, this);
    }
    
    PotionEffectType[] effects = new PotionEffectType[]{PotionEffectType.ABSORPTION, PotionEffectType.BAD_OMEN, PotionEffectType.BLINDNESS, PotionEffectType.CONDUIT_POWER, 
                                                        PotionEffectType.CONFUSION, PotionEffectType.DAMAGE_RESISTANCE, PotionEffectType.DOLPHINS_GRACE, PotionEffectType.FAST_DIGGING,
                                                        PotionEffectType.FIRE_RESISTANCE, PotionEffectType.GLOWING, PotionEffectType.HARM, PotionEffectType.HEAL, PotionEffectType.HEALTH_BOOST, 
                                                        PotionEffectType.HERO_OF_THE_VILLAGE, PotionEffectType.HUNGER, PotionEffectType.INCREASE_DAMAGE, PotionEffectType.INVISIBILITY,
                                                        PotionEffectType.JUMP, PotionEffectType.LEVITATION, PotionEffectType.LUCK, PotionEffectType.NIGHT_VISION, PotionEffectType.POISON, 
                                                        PotionEffectType.REGENERATION, PotionEffectType.SATURATION, PotionEffectType.SLOW, PotionEffectType.SLOW_DIGGING, PotionEffectType.SLOW_FALLING, 
                                                        PotionEffectType.SPEED, PotionEffectType.UNLUCK, PotionEffectType.WATER_BREATHING, PotionEffectType.WEAKNESS, PotionEffectType.WITHER}; 
                                                        
    @EventHandler
    public void onEat(FoodLevelChangeEvent event) {
        HumanEntity p = event.getEntity();
        if (event.getItem() != null) {
            Random generator = new Random();
            int randomIndex = generator.nextInt(effects.length);
            PotionEffectType effect = effects[randomIndex];
    
            PotionEffect randomEffect = new PotionEffect(effect, 600, 2);
    
            p.addPotionEffect(randomEffect);
    
            p.sendMessage("you got " + effect.getName() + " from eating " + event.getItem().getType().name());
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("random potion turned off");
    }
}