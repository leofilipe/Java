import FirstComponent, { FifthComponent } from './FirstComponent'
import SecondComponent from './SecondComponent'
import ThirdComponent from './ThirdComponent'
import FourthComponent from './FourthComponent'
import LearningJavaScript from './LearninJavaScript'

export default function LearningComponent() {
    return (
      <div className="App">
        <FirstComponent></FirstComponent>
        <SecondComponent></SecondComponent>
        <ThirdComponent/>
        <FourthComponent></FourthComponent>
        <FifthComponent></FifthComponent>
        <LearningJavaScript/>
      </div>
    );
  }