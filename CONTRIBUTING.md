## Setup

For setup instructions please see the [fabric wiki page](https://fabricmc.net/wiki/tutorial:setup) that relates to the IDE that you are using.

## Recipe Generation
You can define recipe trees in src/main/resources/recipe_trees.json and EMC values in src/main/resources/emc_values.json.
If you run the `compileRecipes` build task (`./gradlew compileRecipes`), recipes will be generated based on the defined trees and EMC values.

The recipe generator is currently very simple, and doesn't provide a good solution for rounding. This means that each item in a recipe tree should have an EMC value evenly divisible by the previous item's EMC value.

For example, if you define this recipe tree:
```json
{
    "name": "test_tree",
    "items": [
      "minecraft:dirt",
      "minecraft:diamond"
    ]
  }
```

And these EMC values:
```json
{
  "minecraft:dirt": 1,
  "minecraft:diamond": 4
}
```

The following recipes will be generated:

`convert_dirt_to_diamond.json`
```json
{
  "type": "equivalence:shapeless_custom_remainder",
  "ingredients": [
    {
      "item": "equivalence:philosophers_stone"
    },
    {
      "item": "minecraft:dirt"
    },
    {
      "item": "minecraft:dirt"
    },
    {
      "item": "minecraft:dirt"
    },
    {
      "item": "minecraft:dirt"
    }
  ],
  "result": {
    "item": "minecraft:diamond",
    "count": 1
  }
}
```
`convert_diamond_to_dirt.json`
```json
{
  "type": "equivalence:shapeless_custom_remainder",
  "ingredients": [
    {
      "item": "equivalence:philosophers_stone"
    },
    {
      "item": "minecraft:diamond"
    }
  ],
  "result": {
    "item": "minecraft:dirt",
    "count": 4
  }
}
```