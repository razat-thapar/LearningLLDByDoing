# Facade pattern for image editing application

## Problem Statement
You are developing an image editing software that offers various features like loading images, applying filters, adjusting brightness, and saving images. The editing module has complex interactions and dependencies. Your goal is to simplify the interface for users by providing a unified way to access and control these editing functionalities.

## Assignment
Your task is to implement the Facade pattern to refactor the existing `ImageEditingManager` class. The class currently handles image editing functionalities separately. Your objective is to create a facade class that presents a unified and simplified interface for users to perform image editing tasks while abstracting away the internal complexities.

## Implementing the Facade Pattern

1. **Review the original class**: Take a closer look at the `ImageEditingManager` class and its methods. Understand how each editing module is handled and the interactions involved.

2. **Create the facade class**: Create a new class named `ImageEditingFacade` that implements the Facade pattern. This class will encapsulate the interactions with the image editing module, providing a simplified way to edit images.

3. **Remember to call the constructor of your facade using the same arguments from the `ImageEditingManager` class**: Ensure that the constructor of your `ImageEditingFacade` class takes the same arguments that the `ImageEditingManager` class constructor does. This will allow you to pass the necessary dependencies to the facade.

4. **Test your implementation**: Test cases have been provided for you to verify your implementation. Run the test cases to ensure that your facade class works correctly and provides the expected image editing functionality.

## Instructions

1. Create a new class named `ImageEditingFacade`.
2. Implement the Facade pattern within your `ImageEditingFacade` class to simplify image editing interactions.
3. Ensure that your `ImageEditingFacade` constructor takes the same arguments as the `ImageEditingManager` constructor.
4. Run the provided test cases in the `ImageEditingManagerTest` class to verify the correctness of your implementation.