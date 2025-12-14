package immersive_trains;

import immersive_trains.cobalt.registration.Registration;
import immersive_trains.entity.*;
import immersive_trains.item.DyeableAircraftItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public interface Items {
    List<Supplier<Item>> items = new LinkedList<>();

    // Core components - kept for future train development
    Supplier<Item> HULL = register("hull", () -> new Item(baseProps().stacksTo(8)));
    Supplier<Item> ENGINE = register("engine", () -> new Item(baseProps().stacksTo(8)));
    Supplier<Item> BOILER = register("boiler", () -> new Item(baseProps().stacksTo(8)));

    // Single vehicle - to be transformed into a train
    Supplier<Item> AIRSHIP = register("airship", () -> new DyeableAircraftItem(baseProps().stacksTo(1), world -> new AirshipEntity(Entities.AIRSHIP.get(), world)));

    static Supplier<Item> register(String name, Supplier<Item> item) {
        Supplier<Item> register = Registration.register(BuiltInRegistries.ITEM, Main.locate(name), item);
        items.add(register);
        return register;
    }

    static void bootstrap() {
    }

    static Item.Properties baseProps() {
        return new Item.Properties();
    }

    static List<ItemStack> getSortedItems() {
        return items.stream().map(i -> i.get().getDefaultInstance()).toList();
    }
}
