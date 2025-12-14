# Immersive Trains - Development Guide

## Overview

Immersive Trains is a Minecraft 1.21.1 Fabric/NeoForge mod forked from [Immersive Aircraft](https://github.com/Luke100000/ImmersiveAircraft) by Luke100000. This fork serves as a foundation for developing a vanilla-friendly trains mod.

## Current Status

**Phase: Boilerplate Setup (Complete)**

The mod has been successfully rebranded from ImmersiveAircraft to ImmersiveTrains:
- ✅ Namespace changed from `immersive_aircraft` to `immersive_trains`
- ✅ Package structure updated
- ✅ All resource files renamed
- ✅ Mod metadata updated for both Fabric and NeoForge
- ✅ Build configuration updated

**Note:** The mod currently contains aircraft entities as placeholders. Future development will replace these with train-specific entities and mechanics.

## Project Structure

### Multi-Loader Architecture

The project uses a multi-loader architecture supporting both Fabric and NeoForge:

```
ImmersiveTrains/
├── common/          # Shared code between loaders
│   ├── src/main/java/immersive_trains/
│   └── src/main/resources/
├── fabric/          # Fabric-specific implementation
│   ├── src/main/java/immersive_trains/fabric/
│   └── src/main/resources/
└── neoforge/        # NeoForge-specific implementation
    ├── src/main/java/immersive_trains/neoforge/
    └── src/main/resources/
```

### Key Packages

- **`immersive_trains`** - Main entry points and core registries
- **`immersive_trains.entity`** - Entity classes (currently aircraft, to be replaced with trains)
- **`immersive_trains.item`** - Items and their behaviors
- **`immersive_trains.client`** - Client-side rendering and UI
- **`immersive_trains.network`** - Network messages for client-server communication
- **`immersive_trains.config`** - Configuration system
- **`immersive_trains.cobalt`** - Platform-abstraction utilities

### Resources

- **`assets/immersive_trains/`** - Client-side resources (models, textures, sounds, translations)
- **`data/immersive_trains/`** - Data-driven content (recipes, advancements, tags, vehicle configs)

## Core Systems

### 1. Vehicle Entity System

The mod provides a flexible vehicle entity system:

- **`VehicleEntity`** - Base class for all vehicles
- **`EngineVehicle`** - Vehicles with engine mechanics
- **`InventoryVehicleEntity`** - Vehicles with inventory support
- **`AircraftEntity`** - Currently used aircraft base (to be replaced with TrainEntity)

### 2. Upgrade System

Vehicles support data-driven upgrades through:
- **`VehicleUpgrade`** - Defines stat modifications
- **`VehicleStat`** - Stats that can be modified (speed, fuel efficiency, etc.)
- **`VehicleUpgradeRegistry`** - Registry for all upgrades

### 3. Weapon System

Mountable weapons for vehicles:
- **`WeaponMount`** - Mounting point on vehicles
- **`WeaponRegistry`** - Registry for weapon types
- Data-driven weapon configurations

### 4. Network System

Custom networking layer for cross-platform compatibility:
- **`NetworkHandler`** - Platform-independent network interface
- **`Message`** - Base class for network messages
- Separate implementations for Fabric and NeoForge

### 5. Registration System

Platform-abstracted registration:
- **`Registration`** - Cross-platform registration utility
- Automatic registry handling for items, entities, sounds, etc.

## Building the Project

### Prerequisites

- Java 21 or higher
- Gradle (wrapper included)

### Build Commands

```bash
# Build all loaders
./gradlew build

# Build Fabric only
./gradlew :fabric:build

# Build NeoForge only
./gradlew :neoforge:build

# Run Fabric client
./gradlew :fabric:runClient

# Run NeoForge client
./gradlew :neoforge:runClient
```

### Build Outputs

Built JARs will be located in:
- `fabric/build/libs/` - Fabric mod JAR
- `neoforge/build/libs/` - NeoForge mod JAR

## Development Roadmap

### Phase 1: Boilerplate Setup ✅
- [x] Rebrand from ImmersiveAircraft to ImmersiveTrains
- [x] Update all namespaces and identifiers
- [x] Verify build configuration

### Phase 2: Train Entity Foundation (Next)
- [ ] Design train movement mechanics
- [ ] Create base TrainEntity class
- [ ] Implement rail detection/following system
- [ ] Add coupling system for multiple cars

### Phase 3: Train Types
- [ ] Steam locomotive
- [ ] Diesel locomotive
- [ ] Passenger cars
- [ ] Cargo cars
- [ ] Specialty cars (tank, hopper, etc.)

### Phase 4: Rail System
- [ ] Rail placement and detection
- [ ] Switches and junctions
- [ ] Signals and automation
- [ ] Station infrastructure

### Phase 5: Polish & Features
- [ ] Sound design
- [ ] Particle effects
- [ ] Advanced GUI systems
- [ ] Compatibility with existing rail mods

## Code Style Guidelines

### Naming Conventions
- Classes: `PascalCase`
- Methods/Variables: `camelCase`
- Constants: `UPPER_SNAKE_CASE`
- Packages: `lowercase`

### Structure
- Keep entity logic in entity classes
- Use mixins sparingly and document their purpose
- Prefer composition over inheritance
- Make systems data-driven when possible

## Data-Driven Content

The mod uses JSON configs for vehicles:

**Location:** `data/immersive_trains/aircraft/` (to be renamed to `trains/`)

**Example structure:**
```json
{
  "properties": {
    "speed": 1.0,
    "fuel_consumption": 1.0,
    "health": 20.0
  },
  "slots": [
    {
      "type": "weapon",
      "position": [0, 1, 0]
    }
  ]
}
```

## Contributing

When developing new features:

1. Follow the existing code structure
2. Add appropriate comments for complex logic
3. Update language files for new translatable strings
4. Test on both Fabric and NeoForge if possible
5. Document breaking changes

## Useful Resources

- [Fabric Wiki](https://fabricmc.net/wiki/)
- [NeoForge Documentation](https://docs.neoforged.net/)
- [Minecraft Wiki](https://minecraft.wiki/)
- [Original Immersive Aircraft](https://github.com/Luke100000/ImmersiveAircraft)

## License

GPL-3.0-only

## Credits

- **Original Author:** Luke100000 (Immersive Aircraft)
- **Fork Maintainer:** Lemonochrme
- **Contributors:** See README.md for full list
