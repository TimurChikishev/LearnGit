import UIKit
import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    
    let defaultComponentContext: DefaultComponentContext
    
    func makeUIViewController(context: Context) -> UIViewController {
        let targetDependencies = DependenciesImpl(componentContext: defaultComponentContext)
        
        let controller = Main_iosKt.MainViewController(
            targetDependencies: targetDependencies
        )
        
        controller.overrideUserInterfaceStyle = .light
        
        return controller
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    
    let defaultComponentContext: DefaultComponentContext
    
    var body: some View {
        ZStack {
            ComposeView(defaultComponentContext: defaultComponentContext)
                    .ignoresSafeArea(.all) // Compose has own keyboard handler
        }.preferredColorScheme(.dark)
    }
}

private class DependenciesImpl : TargetDependencies {
    let componentContext: DefaultComponentContext
    
    init(componentContext: DefaultComponentContext) {
        self.componentContext = componentContext
    }
}
