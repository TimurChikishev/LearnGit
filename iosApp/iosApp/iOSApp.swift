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
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
