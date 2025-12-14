# Immersive Trains

A simple, vanilla-friendly train mod for Minecraft 1.21.1 Fabric/NeoForge.

This project is a fork of [Immersive Aircraft](https://github.com/Luke100000/ImmersiveAircraft) by Luke100000, repurposed to create a train mod instead of an aircraft mod.

## Status

🚧 **Work in Progress** - This mod is currently in early development. The codebase is being refactored from the original Immersive Aircraft mod to support trains instead of aircraft.

## Goals

- Create a simple, vanilla-faithful train system
- Support both Fabric and NeoForge mod loaders
- Provide a clean, maintainable codebase for future development

## Original Credits

- **Luke100000** - Original Immersive Aircraft mod author
- **Favouriteless** - Added datapack support and exploding vehicle config
- **stohun** - Reworked entity textures
- **김작업** - Reworked icon textures

## License

GPL-3.0-only

## Development

This project uses Architectury to support multiple mod loaders. The project structure:

- `common/` - Shared code between all platforms
- `fabric/` - Fabric-specific code
- `neoforge/` - NeoForge-specific code

### Building

```bash
./gradlew build
```

### Core Architecture

The vehicle system is built on a hierarchy:
- `VehicleEntity` - Base vehicle with collision, passengers, damage handling
- `DyeableVehicleEntity` - Adds dyeable color support
- `InventoryVehicleEntity` - Adds inventory and weapon systems
- `EngineVehicle` - Adds engine/fuel simulation

Vehicles are data-driven using JSON configs in `data/immersive_trains/aircraft/`.
