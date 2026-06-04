import { useState, useEffect } from 'react'
import axios from 'axios'
import './HelloMessage.css'

/**
 * HelloMessage component.
 * Fetches and displays the hello message from the backend API.
 * Handles loading states and errors gracefully.
 */
function HelloMessage() {
  const [message, setMessage] = useState('')
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)
  const [timestamp, setTimestamp] = useState(null)

  /**
   * Effect hook to fetch hello message on component mount.
   */
  useEffect(() => {
    const fetchHelloMessage = async () => {
      try {
        setLoading(true)
        setError(null)
        
        const response = await axios.get('http://localhost:8080/api/hello', {
          timeout: 5000
        })

        setMessage(response.data.message)
        setTimestamp(response.data.timestamp)
        
      } catch (err) {
        console.error('Error fetching hello message:', err)
        
        if (err.response) {
          // Server responded with error status
          setError(`Server Error: ${err.response.status}`)
        } else if (err.request) {
          // Request made but no response received
          setError('Cannot connect to backend. Make sure the server is running on http://localhost:8080')
        } else {
          // Error in request setup
          setError(`Error: ${err.message}`)
        }
      } finally {
        setLoading(false)
      }
    }

    fetchHelloMessage()
  }, [])

  /**
   * Format timestamp to readable date string
   */
  const formatTimestamp = (ts) => {
    if (!ts) return ''
    const date = new Date(ts)
    return date.toLocaleString()
  }

  return (
    <div className="hello-message-container">
      <div className="message-card">
        {loading && (
          <div className="loading-state">
            <div className="spinner"></div>
            <p>Loading message from backend...</p>
          </div>
        )}

        {error && !loading && (
          <div className="error-state">
            <div className="error-icon">⚠️</div>
            <h2>Error</h2>
            <p className="error-message">{error}</p>
          </div>
        )}

        {!loading && !error && (
          <div className="success-state">
            <div className="success-icon">✓</div>
            <h2 className="message-text">{message}</h2>
            {timestamp && (
              <p className="timestamp">
                Received at: {formatTimestamp(timestamp)}
              </p>
            )}
            <p className="backend-info">Message from Spring Boot Backend</p>
          </div>
        )}
      </div>
    </div>
  )
}

export default HelloMessage