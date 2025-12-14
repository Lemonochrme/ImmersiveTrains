# Immersive Trains

This mod adds bunch of vanilla-friendly trains to travel, transport, and explore! The trains have a strong focus on being
vanilla-faithful and many details and functionalities, without being overly complicated.

**Note:** This is a work-in-progress mod forked from [Immersive Aircraft](https://github.com/Luke100000/ImmersiveAircraft) as a base for train development. Currently contains aircraft entities that will be replaced with trains in future updates.

Hosted on [GitHub](https://github.com/Lemonochrme/ImmersiveTrains)

# Original Contributors (Immersive Aircraft)

* Luke100000 (Original author)
* Favouriteless (Added datapack support and exploding vehicle config)
* stohun (Reworked entity textures)
* 김작업 (Reworked icon textures)
* Everyone who helped [to translate](https://crowdin.com/project/immersive-collection)

# Development

This mod is currently being transformed from Immersive Aircraft to support trains instead of aircraft.
The core framework and architecture remain the same, providing:

* `InventoryVehicleEntity` - abstract vehicle with inventory and datapack configuration
* `VehicleStat` - custom stats for vehicles
* `VehicleInventoryDescription` - custom slot registration
* `SlotRenderer` - custom slot rendering
* `JsonConfig` - extensible config options
* `NetworkHandler` and `Registration` - launcher-independent helpers

# Original Base

Forked from [Immersive Aircraft](https://github.com/Luke100000/ImmersiveAircraft) by Luke100000