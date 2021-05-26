import { Col, Container, Row } from 'react-bootstrap';
import './App.css';
import TodoListCard from './components/TodoListCard';
import ConfigContext from './ConfigProvider';

function App({ config }) {
  return (
    <ConfigContext.Provider value={config}>
      <Container>
        <Row>
          <Col md={{ offset: 3, span: 6 }}>
            <TodoListCard />
          </Col>
        </Row>
      </Container>
    </ConfigContext.Provider>
  );
}

export default App;
