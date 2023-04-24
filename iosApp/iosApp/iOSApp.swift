import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
        shared.Koin_commonKt.doInitKoin(
            appDeclaration: { koinApp in
                // Add your Koin configuration code here
            }
        )
    }
 
    private var rootHolder = RootHolder()
    
    var body: some Scene {
        WindowGroup {
            ContentView(defaultComponentContext: rootHolder.defaultComponentContext)
        }
    }
}
 
private class RootHolder {
    let lifecycle: LifecycleRegistry
    let defaultComponentContext: DefaultComponentContext
    
    init() {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()
        
        defaultComponentContext = DefaultComponentContext(lifecycle: lifecycle)
        
        LifecycleRegistryExtKt.create(lifecycle)
    }
    
    deinit {
        LifecycleRegistryExtKt.destroy(lifecycle)
    }
}
