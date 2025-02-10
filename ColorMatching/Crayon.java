// A simple representation of a crayon, storing the Crayon's name and hex color
// Hex colors specify the amount of red, green, and blue in the color using
// hexadecimal values: #RRGGBB
// e.g.) #FF0000 for red

public class Crayon {
	private String name;
	private String hexColor;

	// Constructs a new Crayon with the color white and
	// the hex color value of #FFFFFF
	public Crayon() {
		this("white", "#FFFFFF");
	}

	// Constructs a new Crayon with the given name and hex color
	// Throws an IllegalArgumentException if the given name or hex color values
	// are null or empty 
	public Crayon(String name, String hexColor) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Invalid name.");
		}

		if (hexColor == null || hexColor.isEmpty()) {
			// check valid hex color
			throw new IllegalArgumentException("Invalid hex color.");
		}

		this.name = name;
		this.hexColor = hexColor;
	}

	// Returns the name of this Crayon
	public String getName() {
		return name;
	}

	// Returns the hex color of this Crayon as a String, including the
	// leading hash mark
	// e.g.) "#F74891"
	public String getHexColor() {
		return hexColor;
	}

	// Sets this Crayon's name to the given name
	// Throws an IllegalArgumentException if the given name is null or empty
	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Invalid name.");
		}

		this.name = name;
	}

	// Sets this Crayon's hex color to the given hex color
	// Throws an IllegalArgumentException if the given hex color is null or empty
	public void setHexColor(String hexColor) {
		if (hexColor == null || hexColor.isEmpty()) {
			// check valid hex color
			throw new IllegalArgumentException("Invalid hex color.");
		}

		this.hexColor = hexColor;
	}

	@Override
	public String toString() {
		return this.name + " (" + this.hexColor + ")";
	}
}