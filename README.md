# NYC Map Point-Location Visualizer

An interactive Java Swing application for 2D computational geometry and real-time point-location analysis across New York City.

## Overview
This application processes 2D spatial queries to determine district containment over New York City map imagery. Built with custom geometric primitives, the system maps 16 distinct NYC geographic districts—spanning Manhattan, outer boroughs, and surrounding waterways—and evaluates point-in-polygon queries using ray-casting algorithms.

## Key Features
- **Real-Time Point Location:** Uses 2D ray-casting/crossing-number algorithms to calculate which district contains a target coordinate.
- **Interactive Swing Canvas:** Renders custom polygon boundaries directly over high-resolution NYC map graphics using `Graphics2D`.
- **16 Custom Districts:** Includes precise vector boundaries for Manhattan neighborhoods (Financial District, Midtown, Central Park, Upper East/West Sides, etc.), outer boroughs, and surrounding rivers.
- **Zero External Geometry Libraries:** Implemented entirely from scratch using custom `Point`, `Vector`, `Polygon`, and `Algorithms` classes.

## Getting Started

### Prerequisites
- **Java Development Kit (JDK):** Version 8 or higher.

### Compilation & Execution
1. Clone the repository:
   ```bash
   git clone [https://github.com/YOUR_USERNAME/nyc-point-location-visualizer.git](https://github.com/YOUR_USERNAME/nyc-point-location-visualizer.git)
   cd nyc-point-location-visualizer
