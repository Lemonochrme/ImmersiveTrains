# Getting Started with ImmersiveTrains Development

## Welcome! 🚂

You now have a clean, working boilerplate for developing ImmersiveTrains! This guide will help you understand what's been done and where to start.

## What Has Been Completed ✅

### 1. Complete Namespace Transformation
The entire mod has been successfully rebranded from ImmersiveAircraft to ImmersiveTrains:
- **177 Java files** updated with new package structure
- **All resource files** renamed and updated
- **0 references** to the old `immersive_aircraft` namespace remain
- **Build configuration** fully updated

### 2. Documentation Created
You now have comprehensive documentation:
- **README.md** - Project overview with fork attribution
- **DEVELOPMENT.md** - Detailed development guide
- **TRANSFORMATION_SUMMARY.md** - Complete record of changes
- **SECURITY_SUMMARY.md** - Security analysis
- **GETTING_STARTED.md** - This file!
- **changelog.md** & **todo.md** - Updated for trains

### 3. Project Structure
```
ImmersiveTrains/
├── common/          # Shared code (177 Java files)
├── fabric/          # Fabric-specific implementation
├── neoforge/        # NeoForge-specific implementation
└── Documentation ready for train development
```

## Current State 🔄

The mod is a **working boilerplate** with:
- ✅ Fully functional multi-loader architecture (Fabric + NeoForge)
- ✅ Vehicle entity system (currently aircraft as placeholders)
- ✅ Upgrade system
- ✅ Weapon mounting system
- ✅ Network communication
- ✅ Client rendering
- ⚠️ **Aircraft entities as placeholders** (to be replaced with trains)

## Next Steps - Train Development 🎯

### Phase 1: Design (Recommended First Step)
Before writing code, plan your train system:

1. **Movement Mechanics**
   - Will trains follow Minecraft rails, or use a custom rail system?
   - How will turns and slopes work?
   - What about acceleration and braking?

2. **Train Types**
   - What types of trains? (Steam, diesel, electric, minecart-style?)
   - What's the visual style? (Rustic like aircraft, or modern?)
   - How do trains differ from each other?

3. **Coupling System**
   - How do train cars connect?
   - Can players walk between cars?
   - What about collision between coupled cars?

### Phase 2: Basic Train Entity
Create your first train:

1. **Create TrainEntity class**
   ```java
   // In common/src/main/java/immersive_trains/entity/
   public class TrainEntity extends VehicleEntity {
       // Start simple - copy from BiplaneEntity, then modify
   }
   ```

2. **Register the entity**
   ```java
   // In Entities.java
   Supplier<EntityType<TrainEntity>> BASIC_TRAIN = register("basic_train", ...);
   ```

3. **Create train item**
   ```java
   // In Items.java
   Supplier<Item> BASIC_TRAIN = register("basic_train", 
       () -> new VehicleItem(baseProps(), world -> new TrainEntity(...)));
   ```

4. **Add resources**
   - Model: `assets/immersive_trains/models/entity/basic_train.bbmodel`
   - Texture: `assets/immersive_trains/textures/entity/basic_train.png`
   - Translation: Update `lang/en_us.json`

### Phase 3: Rail System (If Custom Rails)
If using custom rails:

1. **Rail Block**
   - Create custom rail block type
   - Add placement logic
   - Implement pathfinding

2. **Rail Detection**
   - Make trains detect and follow rails
   - Handle curves and elevation
   - Implement switches

### Phase 4: Replace Placeholders
Once you have working trains:

1. **Remove Aircraft Entities**
   - Delete aircraft entity classes
   - Remove aircraft items
   - Update tags (vehicles.json already renamed)
   - Update recipes

2. **Update Textures & Models**
   - Replace aircraft models with train models
   - Update textures in `assets/immersive_trains/textures/`
   - Update item icons

3. **Update Translations**
   - Replace aircraft strings in `lang/` files
   - Update tooltips and descriptions

## Quick Reference 📚

### Key Files to Know

**Main Entry Points:**
- `common/src/main/java/immersive_trains/Main.java` - Mod initialization
- `fabric/src/main/java/immersive_trains/fabric/CommonFabric.java` - Fabric loader
- `neoforge/src/main/java/immersive_trains/neoforge/CommonNeoForge.java` - NeoForge loader

**Registries:**
- `Entities.java` - Register entities here
- `Items.java` - Register items here
- `Sounds.java` - Register sounds here

**Resources:**
- `assets/immersive_trains/` - Models, textures, sounds, translations
- `data/immersive_trains/` - Recipes, tags, vehicle configs

### Important Patterns

**Cross-platform code:**
```java
// Use Main.locate() for resource locations
ResourceLocation id = Main.locate("basic_train");

// Use NetworkHandler for networking
NetworkHandler.sendToServer(new YourMessage());

// Use Registration for registries
Registration.register(...);
```

**Data-driven vehicles:**
Create JSON configs in `data/immersive_trains/aircraft/` (rename to `trains/`):
```json
{
  "properties": {
    "speed": 1.5,
    "health": 50.0
  }
}
```

## Building and Testing 🔧

### Run in Development
```bash
# Fabric
./gradlew :fabric:runClient

# NeoForge
./gradlew :neoforge:runClient
```

### Build Mod JARs
```bash
./gradlew build

# Output:
# fabric/build/libs/immersive_trains-*.jar
# neoforge/build/libs/immersive_trains-*.jar
```

## Tips for Success 💡

1. **Start Small**
   - Make one basic train entity first
   - Get it spawning and moving
   - Then add complexity

2. **Use Existing Code**
   - Study how aircraft entities work
   - Adapt the existing vehicle system
   - Don't reinvent the wheel

3. **Test Both Loaders**
   - Fabric and NeoForge may behave differently
   - Test changes on both when possible

4. **Keep it Data-Driven**
   - Use JSON configs for vehicle properties
   - Makes balancing and modding easier

5. **Document as You Go**
   - Update DEVELOPMENT.md with new systems
   - Comment complex train-specific logic
   - Help future contributors!

## Getting Help 🆘

### Resources
- **Fabric Wiki:** https://fabricmc.net/wiki/
- **NeoForge Docs:** https://docs.neoforged.net/
- **Minecraft Wiki:** https://minecraft.wiki/
- **Original Immersive Aircraft:** https://github.com/Luke100000/ImmersiveAircraft

### Understanding the Codebase
1. Read `DEVELOPMENT.md` for architecture overview
2. Look at `BiplaneEntity.java` as a simple vehicle example
3. Check `VehicleEntity.java` for base functionality
4. Explore `EngineVehicle.java` for engine mechanics

## Your Journey Begins Here! 🚂

The boilerplate is ready. The architecture is solid. The path is clear.

Now it's time to build something amazing! Start with one simple train entity and iterate from there. Good luck, and happy coding! 🎉

---

**Remember:** This is a marathon, not a sprint. The solid foundation you have will make development much smoother. Take your time, test thoroughly, and create something you're proud of!

**Questions?** Check the documentation files or review the original Immersive Aircraft code for examples.

**Ready to code?** Open `common/src/main/java/immersive_trains/entity/` and create your first `TrainEntity.java`! 🚀
