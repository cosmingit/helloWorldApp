import './App.css'
import HelloMessage from './components/HelloMessage'
import ErrorBoundary from './components/ErrorBoundary'

/**
 * Main App component.
 * Wraps the HelloMessage component with error boundary for graceful error handling.
 */
function App() {
  return (
    <ErrorBoundary>
      <div className="app-container">
        <header className="app-header">
          <h1>Hello World Application</h1>
          <p className="subtitle">Full-Stack Application with Spring Boot & React</p>
        </header>
        <main className="app-main">
          <HelloMessage />
        </main>
        <footer className="app-footer">
          <p>&copy; 2024 Hello World App. All rights reserved.</p>
        </footer>
      </div>
    </ErrorBoundary>
  )
}

export default App