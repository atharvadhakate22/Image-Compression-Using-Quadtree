# Image Compression Using Quadtree

This Java project implements an **image compression algorithm** based on the **Quadtree data structure**, a hierarchical spatial subdivision method. It compresses images by recursively splitting them into quadrants and merging uniform regions, reducing file size while maintaining visual quality.

---

## Table of Contents

- [Introduction](#introduction)  
- [How It Works](#how-it-works)  
- [Features](#features)  
- [Class Structure](#class-structure)  
- [Usage Instructions](#usage-instructions)  
- [Example Run](#example-run)  
- [Performance Metrics](#performance-metrics)  
- [Requirements](#requirements)  
- [Notes](#notes)  
- [License](#license)  

---

## Introduction

Image compression reduces the size of image files to save storage space and transmission bandwidth. Unlike traditional compression algorithms (JPEG, PNG), this project uses **Quadtree-based spatial partitioning** to approximate image regions with uniform color blocks.

This technique subdivides an image into square regions and merges blocks where pixel colors are similar, leading to significant reduction in details while preserving overall structure. It is particularly effective on images with large areas of consistent color.

---

## How It Works

1. **Input**: A color image is loaded from disk.  
2. **Quadtree Construction**:  
   - The image is represented as a root node covering the whole image.  
   - Each node computes the **average color** and the **color deviation error** within its region.  
   - If the error exceeds a configurable threshold (adjusted by recursion depth), the node splits into 4 smaller child nodes (top-left, top-right, bottom-left, bottom-right).  
   - This recursive subdivision continues until all leaf nodes have error below the threshold or minimum block size is reached.  
3. **Compression**:  
   - The compressed image is reconstructed by filling each leaf node’s area with its average color, reducing color variations.  
4. **Output**: The compressed image is saved to the specified path.

---

## Features

- Recursive image partitioning using **QuadTree** structure  
- Adaptive subdivision controlled by a **threshold parameter**  
- Average color calculation per node using RMS (root mean square) color values  
- Compression time measurement and detailed statistics  
- Partial rendering to visualize quadtree edges  
- Handles color images (RGB)  
- Supports saving compressed image in original format  

---

## Class Structure

### `CompressImage`

- **Purpose**: Main class handling image compression workflow.  
- **Key Methods**:  
  - `CompressImage(String inputPath, float threshold)` – Loads image and sets threshold.  
  - `build()` – Builds the quadtree and compresses image.  
  - `saveCompressed(String outputPath)` – Renders compressed image and saves it.  
  - `displayCompressionInfo()` – Prints compression statistics.  
  - `saveEdge(String outputPath, int edges)` – Saves partial rendering highlighting quadtree edges.

### `QuadTree`

- **Nested inside `CompressImage`**, this class builds the quadtree from the image.  
- Contains **`QuadTreeNode`** class representing each quadrant:  
  - Stores coordinates, size, average color, error metric, depth, and child nodes.  
  - Computes color statistics for node.  
  - Splits node recursively based on threshold and depth.

---

## Usage Instructions

1. **Compile the project** (assuming `Main.java` and `util/CompressImage.java` are in place):

   ```bash
   javac Main.java
